package com.pzb.jdk.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
//@Documented
@Repeatable(RepeatContainer.class)
public @interface UserRepeatAnno {
    // 使用@interface 定义一个注解 注解之中定义的都是方法 每一个方法其实是声明的参数 方法名称即是参数名称 方法返回类型即是参数类型
    // 参数类型可谓基本类型 Class类型 Enum(枚举) String Annotaion 或者以上的数组[]，不能为任何封装的类型以及自定义的类
    // 方法后可以接default 指定方法的默认值
    // 非基本类型如String 素默认值不能为null
    // 所有的自定义注解都是继承自 Annotation 类型 且不可再继承其他接口以及注解. 代码中不直接写明继承自Annotation 这个过程的细节是编译器完成的
    String name() default "hello";
    int age() default -1;
}

