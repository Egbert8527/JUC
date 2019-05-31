package com.jcoder.JUC.bingfa.chapter2;

public class Node2 implements Runnable{

    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run(){
                System.out.println("hello ,I'm t1");
            }
        };
        Thread t2 = new Thread(new Node2());
        t1.start();
        t2.start();
    }


        @Override
        public void run() {
            System.out.println("I am thread2 ");
        }

}
