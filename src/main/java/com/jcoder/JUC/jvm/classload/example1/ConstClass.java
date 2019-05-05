package com.jcoder.JUC.jvm.classload.example1;

public class ConstClass {
    static {
        System.out.println("ConstClass init");
    }
    public static final String HELLOWORLD = "hello world";
}
