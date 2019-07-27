package com.jcoder.JUC.bingfa.chapter5.node5;

public class Client {

    public Data request(final String queryStr){
        final FutureData future = new FutureData();
        new Thread(){
            public void run(){
                RealData realData = new RealData(queryStr);
                future.setRealData(realData);
            }
        }.start();
        return future;
    }

}
