package com.mzy.thread;

public class VolatileExample {
    private static volatile int counter = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++)
                        counter++;
                }
            });
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }
    /**
     * 这里说明counter++不是一个原子性的操作
     * 这里包含了三个步骤：1。读取变量counter的值
     * 2.对counter加一；3.将新值赋给变量counter
     * 如果线程a读取counter到工作区内存后，其他线程对这个值已经进行了自增操作
     * 那个线程A这个值就是一个过期的值，所以结果必然小于100000
     */
}
