package com.pzb.jdk;

import com.pzb.PMD.JuniorClass;
import com.pzb.PMD.SeniorClass;

public class Demo {
    public static void main(String[] args) {
        JuniorClass juniorClass = new JuniorClass();

        SeniorClass seniorClass = new SeniorClass();
        seniorClass.invokePre();

        juniorClass.prefetch();
    }
}
