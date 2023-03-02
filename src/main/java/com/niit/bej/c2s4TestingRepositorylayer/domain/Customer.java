package com.niit.bej.c2s4TestingRepositorylayer.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {
    @Id
    private int customerId;
    private String customerName;
    private long customerPhoneNo;
    private Product customerProduct;

}
