package com.jcoder.JUC.bingfa.chapter4.node4;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterDemo {

    public static class Candidate{
        volatile int id;
        public volatile int score;
    }

    public final static AtomicIntegerFieldUpdater<Candidate> scoreUpdater
            = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");

    public static AtomicInteger allScore = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final Candidate stu = new Candidate();
        Thread[] t = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            t[i] = new Thread(){
                @Override
                public void run() {
                    if (Math.random()>0.4){
                        scoreUpdater.incrementAndGet(stu);

                        allScore.incrementAndGet();
                    }
                }
            };
            t[i].start();
        }
        for (int i=0;i<1000;i++){t[i].join();}
        System.out.println("score  = "+stu.score);
        System.out.println("allScore =" + allScore);


    }
}
