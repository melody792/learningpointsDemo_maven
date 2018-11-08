package com.pzb.jdk.subpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyReflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MyAnnotationTest myAnnotationTest = new MyAnnotationTest();
        Method method = MyAnnotationTest.class.getMethod("output", new Class[]{});
        if (MyAnnotationTest.class.isAnnotationPresent(MyAnnotation.class)){//类上是否有注解
            System.out.println("MyAnnotationTest.class have annotation");
        }
        if (method.isAnnotationPresent(MyAnnotation.class)){//方法上是否有
            method.invoke(myAnnotationTest, null);//调用方法
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            myAnnotation.hello();//
            System.out.println(myAnnotation.style());//获取注解里的信息
        }
        //得到output方法上的所有注解，当然是被RetentionPolicy.RUNTIME修饰的
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations){
            System.out.println(annotation.annotationType().getName());
        }
    }
}
