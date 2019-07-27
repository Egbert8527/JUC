package com.jcoder.JUC.bingfa.chapter5.node3;

public final class PCData {

    private final int intData;

    public PCData(int d) {
        this.intData = d;
    }


    public PCData(String d) {
        intData = Integer.valueOf(d);
    }

    public int getData(){
        return intData;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "intData=" + intData +
                '}';
    }
}
