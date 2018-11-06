package com.pzb.PMD;


import javax.inject.Inject;

public class SeniorClass {
    @Inject
    private JuniorClass juniorClass;

    public void invokePre (){
        //GuiceDemoServiceImpl juniorClass = new GuiceDemoServiceImpl();
        juniorClass.prefetch();
    }
    public SeniorClass(){
        toString(); //may throw NullPointerException if overridden
    }
    public String toString(){
        return "IAmSeniorClass";
    }
}

