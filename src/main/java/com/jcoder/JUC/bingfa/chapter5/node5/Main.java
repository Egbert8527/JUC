package com.jcoder.JUC.bingfa.chapter5.node5;

public class Main {

    public static void main(String[] args) {
        Client client = new Client();
        //这里会立即返回，因为得到的是FutureData 而不是 RealData
        Data data = client.request("name");
        System.out.println("请求完毕");

        try {
            //这里可以用sleep代替了对其他业务逻辑的处理
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        //使用真实数据
        System.out.println("数据 = " + data.getResult());
    }
}
