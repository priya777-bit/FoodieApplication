package com.example.OrderService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private String restaurantId;
    private String restaurantName;
    private String restaurantLocation;
    private List<Food> dishList;
}
