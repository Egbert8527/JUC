package com.jcoder.JUC.bingfa.chapter4.node3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo_GC {

    static volatile ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected void finalize() throws Throwable {
            System.out.println(this.toString()+" is GC");

        }
    };

    static volatile CountDownLatch cd = new CountDownLatch(10000);

    public static class ParseDate implements Runnable{

        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            //parse("2016-08-07 11:33:"+i % 60)
            try {
            if (t1.get()==null){
                t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"){
                    @Override
                    protected void finalize() throws Throwable {
                        System.out.println(this.toString() + "is GC");
                    }
                });
                System.out.println(Thread.currentThread().getId()+ ":create SimpleDateFormat");
            };

                Date t = t1.get().parse("2018-08-11 13:20:"+i%60);
            } catch (ParseException e) {
                e.printStackTrace();
            }finally {
                cd.countDown();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i=0;i<10000;i++){
            es.execute(new ParseDate(i));
        }
        cd.await();
        System.out.println("mission complete");
        t1 = null;
        System.gc();
        System.out.println("first GC complete");
        //在设置 ThreadLocal的时候，会清除ThreadLocalMap中无效的对象
        t1 = new ThreadLocal<SimpleDateFormat>();
        cd = new CountDownLatch(1000);
        for (int i=0;i<10000;i++){
            es.execute(new ParseDate(i));
        }
        cd.await();
        Thread.sleep(1000);
        System.gc();
        System.out.println("second GC complete!");

    }
}
