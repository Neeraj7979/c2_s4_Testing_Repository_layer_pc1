package com.niit.bej.c2s4TestingRepositorylayer.domain;

public class Product {
    private int productId;
    private String productName;
    private String productDescription;

    public Product(int productId, String productName, String productDescription) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
    }
}
