package com.example.OrderService.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Order {

    private String orderId;
    private String userMailId;
    private Restaurant restuarant;
    private List<Food> foodList;
    private double price;
}
