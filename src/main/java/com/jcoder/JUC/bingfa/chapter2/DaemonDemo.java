package com.jcoder.JUC.bingfa.chapter2;

/**
 * 守护线程
 */
public class DaemonDemo {


    public static class DaemonT extends Thread{

        @Override
        public void run() {
            System.out.println("I 'm alive");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I complete task");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new DaemonT();
        //t.setDaemon(true);
        t.start();
        Thread.sleep(2000);
    }
}
