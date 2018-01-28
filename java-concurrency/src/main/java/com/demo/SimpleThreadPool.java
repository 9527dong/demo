package com.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 初始版线程池
 */
public class SimpleThreadPool {
    private final int size;
    //默认线程数
    private final static int DEFAULT_SIZE = 10;
    //一个自增序列，记录线程池中的线程的数量
    private static volatile int seq;
    //线程前缀
    private static final String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";
    //线程组名称
    private static final ThreadGroup GROUP = new ThreadGroup("Pool_Group");
    //任务队列
    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();
    //当前线程池中的线程数
    private static final List<WorkerTask> THREAD_QUEUE = new ArrayList<>();

    public SimpleThreadPool(int size) {
        this.size = size;
        init();
    }

    public SimpleThreadPool() {
        this(DEFAULT_SIZE);
    }

    private void init() {
        for (int i = 0; i < size; i++) {
            createWorkTask();
        }
    }

    private void createWorkTask() {
        WorkerTask task = new WorkerTask(GROUP, THREAD_PREFIX + (seq++));
        task.start();
        THREAD_QUEUE.add(task);
    }

    public void submit(Runnable runnable) {
        synchronized (TASK_QUEUE) {
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    private enum TaskState {
        FREE, RUNNING, BLICKED, DEAD;
    }

    private static class WorkerTask extends Thread {
        private volatile TaskState taskState = TaskState.FREE;

        public WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        public TaskState getTaskState() {
            return taskState;
        }

        @Override
        public void run() {
            while (this.taskState != TaskState.DEAD) {
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLICKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    runnable = TASK_QUEUE.removeFirst();

                }
                if (runnable != null) {
                    taskState = TaskState.RUNNING;
                    runnable.run();
                    taskState = TaskState.FREE;
                }
            }
        }
    }

    public static void main(String[] args) {
        SimpleThreadPool threadPool = new SimpleThreadPool();
        for (int i = 0; i < 40; i++) {
            threadPool.submit(() -> {
                System.out.println("The runnable be serviced by " + Thread.currentThread() + " start.");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("The runnable be serviced by " + Thread.currentThread() + " finished.");
            });
        }
    }
}
