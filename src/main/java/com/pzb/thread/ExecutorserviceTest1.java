package com.pzb.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorserviceTest1 {
    public static void main(String[] args) throws InterruptedException{
        //threadExecutor();
        executorService();
    }

    public static void threadExecutor() throws InterruptedException{
        for (int i = 0; i < 10; i++) {
            new Thread("thread"+i) {
                @Override
                public void run(){
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+" finished");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
        Thread.sleep(2000);
        System.out.println("main thread finished");
    }

    public static void executorService(){
        ExecutorService executorservice = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorservice.submit(new Thread("thread"+ i){
                @Override
                public void run(){
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+" finished");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorservice.shutdown();//发送一个通知 不是立即

        try {
            boolean finish = executorservice.awaitTermination(2000, TimeUnit.MILLISECONDS);
            if (!finish){
                executorservice.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            executorservice.shutdownNow();
        }
        System.out.println("main thread wait for sub thread finished");
    }
}
