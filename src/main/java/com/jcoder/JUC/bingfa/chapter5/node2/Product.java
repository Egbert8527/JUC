package com.jcoder.JUC.bingfa.chapter5.node2;

import lombok.Getter;

@Getter
public final class Product {

    private final String no;
    private final String name;
    private final double price;

    public Product(String no, String name, double price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

}
