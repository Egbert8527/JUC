package com.jcoder.JUC.bingfa.chapter5.node1;


public class SingletonEnum {

    private SingletonEnum(){}

    private static class Inner{
        private static SingletonEnum SINGLETION=new SingletonEnum();
    }

    public static SingletonEnum getInstance(){
        return Inner.SINGLETION;
    }
}
