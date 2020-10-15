package com.mzy.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService newCachedTheadPool = Executors.newCachedThreadPool();
        Future<String> future = newCachedTheadPool.submit(new MyCallable());
        if (!future.isDone()){
            System.out.println("task has not finished, please wait!");
        }
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            newCachedTheadPool.shutdown();
        }
    }
    /**
     * 这里是使用线程池进行任务执行，线程池就是比较方便管理
     */
}
