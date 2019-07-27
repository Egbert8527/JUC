package com.jcoder.JUC.bingfa.chapter5.node4;

import com.lmax.disruptor.EventFactory;

public class PCDataFactory implements EventFactory<PCData> {

    public PCData newInstance(){
        return new PCData();
    }
}
