package com.pzb.jdk.subpackage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)// eg @Deprecated
@Target(ElementType.METHOD)//只能声明在方法上
public @interface MyTarget {
    String value() default "hello";
}
