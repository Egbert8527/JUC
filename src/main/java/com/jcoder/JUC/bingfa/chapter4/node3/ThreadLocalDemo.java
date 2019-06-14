package com.jcoder.JUC.bingfa.chapter4.node3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static class ParseData implements  Runnable{

        int i=0;
        public ParseData(int i ){this.i = i ;}



        @Override
        public void run() {
            try {
                Date t = sdf.parse("2018-08-05 13:22:00");
                System.out.println(i+ ": " + t);
            }catch (ParseException e){
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i=0;i<1000;i++){
            es.execute(new ParseData(i));
        }
    }

}
