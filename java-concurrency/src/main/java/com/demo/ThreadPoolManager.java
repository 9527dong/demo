package com.demo;

import java.util.LinkedList;
import java.util.List;

public class ThreadPoolManager {
    static interface RunnableTask {
        public void run();
    }

    private int max_thread_size = 0;
    private int min_thread_size = 0;
    private int active_thread_size = 0;
    private List<RunnableTask> runnableList = null; //任务队列
    private ThreadTask[] tasks = null;

    public ThreadPoolManager() {
        this(2, 8, 6);
    }

    public ThreadPoolManager(int minSize, int maxSize, int
            activeSize) {
        this.min_thread_size = minSize;
        this.max_thread_size = maxSize;
        this.active_thread_size = activeSize;
        init();
    }

    private void init() {
        runnableList = new
                LinkedList<ThreadPoolManager.RunnableTask>();
        tasks = new ThreadTask[min_thread_size];
        for (int i = 0; i < min_thread_size; i++) {
            tasks[i] = new ThreadTask("-" + i, runnableList);
            tasks[i].start();
        }
    }

    public void execute(RunnableTask task) {
        synchronized (runnableList) {
            ((LinkedList<RunnableTask>) runnableList).addLast(task);
            runnableList.notify();
        }
    }

    private class ThreadTask extends Thread {
        private String name = "";
        private List<RunnableTask> runnableList = null;

        public ThreadTask(String name, List<RunnableTask>
                runnableList) {
            super(name);
            this.name = name;
            this.runnableList = runnableList;
        }

        @Override
        public void run() {
            while (true) {
                RunnableTask task = null;
                synchronized (runnableList) {
                    while (runnableList.isEmpty()) {
                        try {
                            runnableList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = ((LinkedList<RunnableTask>) runnableList).removeFirst()
                    ;
                }
                task.run();
            }
        }
    }
}