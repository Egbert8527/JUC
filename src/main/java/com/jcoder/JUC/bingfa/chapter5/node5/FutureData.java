package com.jcoder.JUC.bingfa.chapter5.node5;

public class FutureData implements Data{

    protected RealData realData = null;
    protected boolean isReady = false;

    public synchronized void setRealData(RealData realData){
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();
    }


    @Override
    public String getResult() {
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        return realData.result;
    }
}
