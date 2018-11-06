package com.pzb.thread;

import static java.lang.System.*;

public class BadSuspend {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("T1");
    static ChangeObjectThread t2 = new ChangeObjectThread("T2");


    private static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                out.println("in    " + getName());
                Thread.currentThread().suspend();
            }
        }
    }

    public static class Join{
        public volatile static int i = 0;
        public static class AddTread extends Thread{
            @Override
            public void run(){
                for (i=0;i<10000000;i++);
            }
        }
    }

    public static class DeamonT extends Thread{
        @Override
        public void run(){
            while (true) {
                out.println("isAlive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //testBad();
        //testJoin();
        testDeamon();
    }

    private static void testDeamon() {
        Thread deamonT =  new DeamonT();
        deamonT.setDaemon(true);
        deamonT.start();
    }

    private static void testJoin() throws InterruptedException {
        //执行结果1000000 等待线程结束后的i
        Join.AddTread addTread = new Join.AddTread();
        addTread.start();
        //Thread.sleep(10);
        addTread.join();
        //addTread.wait(0);
        out.println(Join.i);
    }

    private static void testBad() throws InterruptedException {
        //执行结果 t1结束 t2线程一直挂起
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.resume();
        t2.resume();
        t1.join();
        t2.join();
    }

}
