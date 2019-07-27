package com.jcoder.JUC.bingfa.chapter5.node3;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

@Slf4j
public class Consumer implements Runnable{

    private BlockingQueue<PCData> queque;

    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCData> queque) {
        this.queque = queque;
    }

    @Override
    public void run() {
        System.out.println("start Consumer id = " + Thread.currentThread().getId());
        Random r = new Random();
        try {
            while (true) {
                PCData data = queque.take();
                if (null != data) {
                    //计算平方
                    int re = data.getData() * data.getData();
                    log.info("{0}*{1}={2}", data.getData(),data.getData(),re);
                    Thread.sleep(r.nextInt(SLEEPTIME));

                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
