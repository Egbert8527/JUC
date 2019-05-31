package com.jcoder.JUC.bingfa.chapter2;

public class PriorityDemo {


    public static class HightPriority extends Thread{
        static int count = 0;
        public void run(){
            while (true){
                synchronized (PriorityDemo.class){
                    count++;
                    if (count>10000000){
                        System.out.println("HightPriority is complete!");
                        break;
                    }
                }
            }

        }
    }

    public static class LowerPriority extends Thread{
        static int count = 0;
        public void run(){
            while (true){
                synchronized (PriorityDemo.class){
                    count++;
                    if (count>10000000){
                        System.out.println("LowerPriority is complete!");
                        break;
                    }
                }
            }

        }
    }


    public static void main(String[] args) {
        Thread high = new HightPriority();
        Thread low = new LowerPriority();
        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);
        low.start();
        high.start();

    }


}
