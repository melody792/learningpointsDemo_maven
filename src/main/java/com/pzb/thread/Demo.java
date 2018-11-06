package com.pzb.thread;

public class Demo {
    static AccountingSync instance = new AccountingSync();
    public static class AccountingSync implements Runnable {
        static int i;
        public synchronized void increase(){
            i++;
        }
        public void run() {
            for (int j = 0; j<1000000; j++){
                increase();//给实例方法加锁，作用于实例方法上，不同线程必须操作同一实例,否则结果testSynchronized_diffInstance
//                synchronized(instance){//给对象实例进行加锁
//                    i++;
//                }
            }
        }
    }
    public static class AccountingSync_static implements Runnable {
        static int k;
        public synchronized static void increase1(){
            k++;
        }
        public void run() {
            for (int j = 0; j<1000000; j++){
                increase1();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //testSynchronized();
        testSynchronized_diffInstance();
    }

    private static void testSynchronized_diffInstance() throws InterruptedException {
        //执行结果 如果两个线程new两个不同实例，结果小于2000000,如果synchronized作用于静态方法，相当于作用于类上
        Thread thread1 = new Thread(new AccountingSync());
        Thread thread2 = new Thread(new AccountingSync());
        thread1.start(); thread2.start();
        thread1.join(); thread2.join();
        System.out.println("作用于类方法上"+AccountingSync.i);
        //执行结果2000000 作用于静态方法上 相当于作用于类上 即使new不同实例
        Thread thread3 = new Thread(new AccountingSync_static());
        Thread thread4 = new Thread(new AccountingSync_static());
        thread3.start(); thread4.start();
        thread3.join(); thread4.join();
        System.out.println("作用于静态类方法上"+AccountingSync_static.k);
    }

    private static void testSynchronized() throws InterruptedException {
        //执行结果 如果不加关键字synchronized执行结果小于200000线程不安全（多个线程操作同一个资源），加上执行结果等于200000
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(AccountingSync.i);
    }
}
