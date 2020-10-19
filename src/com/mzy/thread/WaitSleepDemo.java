package com.mzy.thread;

public class WaitSleepDemo {

    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock) {
                    try {
                        System.out.println("thread A get lock");
                        Thread.sleep(10);
                        System.out.println("thread A do waiting method");
                        lock.wait(1000);
                        System.out.println("thread A is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock) {
                    try {
                        System.out.println("thread B get lock");
                        System.out.println("thread B sleeping 10 ms");
                        Thread.sleep(10);
                        System.out.println("thread B is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * 这里有等待吃的概念
     * 锁池和等待池
     */
}
