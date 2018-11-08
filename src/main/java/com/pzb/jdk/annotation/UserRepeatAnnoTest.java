package com.pzb.jdk.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

//注解多用于框架当中 也可应用于实行配置场景中
public class UserRepeatAnnoTest {
    @UserRepeatAnno(name = "aa", age = 22)
    @UserRepeatAnno(name = "bb", age = 33)
    public void method1(){

    }
    @UserRepeatAnno(name = "cc", age = 44)
    @UserRepeatAnno(name = "dd", age = 55)
    public void method2(){

    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method1 = UserRepeatAnnoTest.class.getMethod("method1");
        Annotation annotation1 = method1.getAnnotation(RepeatContainer.class);
        System.out.println("-----------------case1----------------");
        System.out.println(annotation1);
        for (UserRepeatAnno item : ((RepeatContainer) annotation1).value()){
            System.out.println(item.name()+ "------" +item.age());
        }
        System.out.println("-----------------case2----------------");
        Annotation t2 = method1.getAnnotation(UserRepeatAnno.class);
        System.out.println(t2);// 错误的访问方式输出为null 因为这些注解存储在容器里面 不是表面上直接标注于方法上
        System.out.println("-----------------case3----------------");
        System.out.println(method1.getAnnotations().length);// 这个长度为1 因为返回的是容器类型 RepeatContainer
        System.out.println("-----------------case4----------------");
        System.out.println(method1.getAnnotationsByType(UserRepeatAnno.class).length);
        for (UserRepeatAnno item : method1.getAnnotationsByType(UserRepeatAnno.class)){
            System.out.println(item.name()+ "------" +item.age());
        }
    }
}
