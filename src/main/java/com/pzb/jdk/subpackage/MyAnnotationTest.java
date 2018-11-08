package com.pzb.jdk.subpackage;

@MyAnnotation(hello = "1", array = {}, lannotation = @MyTarget, world = "2")
public class MyAnnotationTest {
    @MyAnnotation(lannotation=@MyTarget(value="baby"), world = "shanghai",array={1,2,3})
    @Deprecated
    @SuppressWarnings("")
    public void output()
    {
        System.out.println("output something!");
    }
}
