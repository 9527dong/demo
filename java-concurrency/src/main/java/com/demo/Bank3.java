package com.demo;

class TicketWindow3 implements Runnable {
    private int max_value = 0;
    private Object lock = new Object();
    private boolean flag = true;

    public void run() {
        if (flag) {
            while (true) {
                synchronized (lock) {
                    if (max_value > 500) {
                        break;
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(Thread.currentThread().getName()
                            + ":lock..." + max_value++);
                }
            }
        } else {
            while (true)
                if (ticket())
                    break;
        }
    }

    private synchronized boolean ticket() {
        if (max_value > 500) {
            return true;
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + ": method.."
                + max_value++);
        return false;
    }

    public void change() throws InterruptedException {
        Thread.sleep(30);//读者可以自行思考为什么要sleep
        this.flag = false;
    }
}

public class Bank3 {
    public static void main(String[] args) throws InterruptedException {
        TicketWindow3 tw3 = new TicketWindow3();
        Thread t1 = new Thread(tw3);
        Thread t2 = new Thread(tw3);
        t1.start();
        tw3.change();
        t2.start();
    }
}
