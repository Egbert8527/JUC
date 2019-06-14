package com.jcoder.JUC.bingfa.chapter4.node3;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;

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
            if (t1.get()==null){
                t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"){
                    @Override
                    protected void finalize() throws Throwable {
                        System.out.println(this.toString() + "is GC");
                    }
                });
            };
        }
    }
}
