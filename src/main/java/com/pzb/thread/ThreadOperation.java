package com.pzb.thread;

public class ThreadOperation {
    public static void main(String[] args) {

        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        int noThreads = currentGroup.activeCount();
        Thread[] lstThreads = new Thread[noThreads];
        currentGroup.enumerate(lstThreads);
        for (int i = 0; i < noThreads; i++)
            System.out.println("thread id:" + i + " = " + lstThreads[i].getName());
    }
}
