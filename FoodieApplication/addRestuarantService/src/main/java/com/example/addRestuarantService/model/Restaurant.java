package com.example.addRestuarantService.model;

import lombok.Data;

import java.util.List;

@Data
public class Restaurant {

    private String restaurantId;
    private String restaurantName;
    private String restaurantLocation;
    private List<Dish> dishList;
}
