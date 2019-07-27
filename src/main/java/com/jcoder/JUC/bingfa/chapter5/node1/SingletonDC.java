package com.jcoder.JUC.bingfa.chapter5.node1;

public class SingletonDC {
    private static volatile SingletonDC instance;

    private SingletonDC(){};

    public static SingletonDC getInstance() {
        if (instance == null) {
            synchronized (SingletonDC.class) {
                if (instance == null) {
                    instance = new SingletonDC();
                }
            }
        }
        return instance;
    }

}
