package com.pzb.guice;

public class GuiceDemoServiceImpl implements GuiceDemoService {
    public static boolean prefetchInvoked = false;

    @Override
    public void prefetch(){
        if (!prefetchInvoked){
            System.out.println("prefetchInvoked is " + prefetchInvoked + "set it ");
            prefetchInvoked = true;
        } else {
            System.out.println("prefetchInvoked is " + prefetchInvoked);
        }
    }
}
