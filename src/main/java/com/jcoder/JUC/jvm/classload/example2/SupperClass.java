package com.jcoder.JUC.jvm.classload.example2;

public class SupperClass {
    static {
        System.out.println("SupperClass init");
    }

    public SupperClass() {
        System.out.println("My Construct init");
    }

    public static int value = 3;
}
