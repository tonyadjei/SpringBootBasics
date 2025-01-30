package com.tonyadjei.springbootbasics.Exercise8;


import lombok.*;

@Getter
@Setter
@ToString
public class Product {
    private String name;
    private Float price;
    private int id;
    private static int nextIDCount = 0;

    {
        nextIDCount += 1;
    }

    public Product(String name, Float price) {
        this.name = name;
        this.price = price;
        this.id = nextIDCount;
    }
}
