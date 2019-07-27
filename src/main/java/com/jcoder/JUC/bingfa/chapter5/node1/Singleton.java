package com.jcoder.JUC.bingfa.chapter5.node1;


public class Singleton {

    private void Signleton(){
        System.out.println("Singleton is create");
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

}
