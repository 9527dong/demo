package com.demo;

/**
 * 简易版生产者消费者
 */
class NumberFactory {
    private int i = 0;
    private Object lock = new Object();

    public void create() {
        synchronized (lock) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("create...i-" + i++);
        }
    }

    public void consume() {
        synchronized (lock) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("consume...i-" + i);
        }
    }
}

public class ProducerAndCustomer {
    final static NumberFactory numberFactory = new NumberFactory();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    numberFactory.create();
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    numberFactory.consume();
                }
            }
        }).start();
    }
}

