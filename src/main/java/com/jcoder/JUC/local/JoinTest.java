package com.jcoder.JUC.local;

public class JoinTest {



    public static class DemoTask implements Runnable{

        int index ;

        public DemoTask(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println("Task "+index+" Start");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task "+index+" End");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DemoTask(1));
        Thread t2 = new Thread(new DemoTask(2));

        t1.start();
        t1.join();

        t2.start();

        t2.join();
    }

}
