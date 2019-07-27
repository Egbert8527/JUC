package com.jcoder.JUC.bingfa.chapter5.node4;

import com.lmax.disruptor.WorkHandler;

public class Consumer implements WorkHandler<PCData> {

    @Override
    public void onEvent(PCData event) throws Exception {
        System.out.println(Thread.currentThread().getId()+":Event: --" + event.get()* event.get() + "--");
    }
}
