package com.example.OrderService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Order {

    @Id
    private String orderId;
    private String userMailId;
    private List<Restaurant> restaurantList;
    private double quantity =1;
    private double price;
}
