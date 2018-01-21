package com.demo;

public class ThreadPoolTest1 {
    public static void main(String[] args) {
        final ThreadPoolManager.RunnableTask task = new ThreadPoolManager.RunnableTask() {
            public void run() {
                System.out.println(Thread.currentThread().getName()
                        + "...is execute...");
            }
        };
        ThreadPoolManager poolManager = new ThreadPoolManager();
        for (int i = 0; i < 10; i++) {
            poolManager.execute(task);
        }
    }
}