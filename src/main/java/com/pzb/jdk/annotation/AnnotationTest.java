package com.pzb.jdk.annotation;

import java.lang.reflect.Method;

public class AnnotationTest {
    @MyTarget //(value = "world")
    public void doSomething(){
        System.out.println("annotation with @MyTarget");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = AnnotationTest.class.getMethod("doSomething",null);
        if (method.isAnnotationPresent(MyTarget.class)){
            System.out.println(method.getAnnotation(MyTarget.class));
        }
        MyTarget myTarget = method.getAnnotation(MyTarget.class);
        System.out.println(myTarget.value());
    }
}
