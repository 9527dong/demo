package com.demo;

public class TreadGroupTest {
    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("tg1");
        Thread t1 = new Thread(tg, "线程1") {
            @Override
            public void run() {
                while (true) {
                    System.out.println("t1...." + getThreadGroup().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t2 = new Thread(tg, "线程2") {
            @Override
            public void run() {
                while (true) {
                    System.out.println("t2....");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t3 = new Thread(tg, "线程3") {
            @Override
            public void run() {
                while (true) {
                    System.out.println("t3....");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        System.out.println("Active Count:" + tg.activeCount());
        t2.start();
        System.out.println("Active Count:" + tg.activeCount());
        t3.start();
        System.out.println("Active Count:" + tg.activeCount());
        tg.list();
    }
}