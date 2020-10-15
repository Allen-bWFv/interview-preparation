package com.mzy.thread;

public class ThreadTest1 {

    private static void attack(){
        System.out.println("Fight");
        System.out.println("Current Thread is:" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                attack();
            }
        };
        System.out.println("current main thread is:" + Thread.currentThread().getName());
        t.start();
    }
    /**
     * 这里可以看出run方法和start方法是不同的
     * 首先执行run方法，可以看到此时执行run方法的还是主线程
     * 但是start是会先创建一个子线程，然后通过ThreadRun方法调用run方法
     */
}
