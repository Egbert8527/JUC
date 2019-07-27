package com.jcoder.JUC.bingfa.chapter5.node5;

public class RealData implements Data{

    protected final String result;


    public RealData(String para){
        //RealData的构造可能很慢，需要用户等很久，这里使用sleep模拟
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <10 ; i++) {
            sb.append(para);
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
        }
        result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
