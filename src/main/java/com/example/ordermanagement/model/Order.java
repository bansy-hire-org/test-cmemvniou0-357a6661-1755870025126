package com.example.ordermanagement.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("Order")
public class Order implements Serializable {

    @Id
    private String id;
    private String customerName;
    private String orderDate;
    private String shippingAddress;
    private double totalAmount;
}