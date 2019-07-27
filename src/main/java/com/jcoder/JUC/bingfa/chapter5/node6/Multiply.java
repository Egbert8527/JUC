package com.jcoder.JUC.bingfa.chapter5.node6;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Multiply implements Runnable{

    public static BlockingQueue<Msg> bq = new LinkedBlockingDeque<Msg>();


    @Override
    public void run() {
        while (true) {
            try {
                Msg msg = bq.take();
                msg.i = msg.i * msg.j;
                Div.bq.add(msg);
            } catch (InterruptedException e) {
            }
        }
    }
}
