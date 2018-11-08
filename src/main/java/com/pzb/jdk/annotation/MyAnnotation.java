package com.pzb.jdk.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation
{
    String hello() default "gege";
    String world();
    int[] array() default { 2, 4, 5, 6 };
    MyTarget lannotation() default @MyTarget(value = "ddd");
    Class style() default String.class;
}