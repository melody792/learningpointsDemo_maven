package com.pzb.PMD;

public class JuniorClass implements JuniorInterFace{
    private String name;
    boolean prefetchInvoked;

    @Override
    public void prefetch(){
        if (!prefetchInvoked){
            System.out.println("prefetchInvoked is " + prefetchInvoked);
            prefetchInvoked = true;
        } else {
            System.out.println("prefetchInvoked is " + prefetchInvoked);
        }
    }
    public JuniorClass(){
        super(); //Automatic call leads to NullPointerException
        name = "GuiceDemoServiceImpl";
    }
    public String toString1(){
        return name.toUpperCase();
    }
}
