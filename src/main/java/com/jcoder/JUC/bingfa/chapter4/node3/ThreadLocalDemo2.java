package com.jcoder.JUC.bingfa.chapter4.node3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo2 {

    static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<SimpleDateFormat>();

    public static class ParseData implements Runnable{

        int i = 0;

        public ParseData(int i){this.i = i;}

        @Override
        public void run() {
            if (t1.get()==null){
                System.out.println("创建SimpleDateFormat对象");
                t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            }
            try {
                Date t = t1.get().parse("2018-08-11 13:20:11");
                System.out.println(i+":"+t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i=0;i<1000;i++){
            es.execute(new ThreadLocalDemo2.ParseData(i));
        }
    }

}
