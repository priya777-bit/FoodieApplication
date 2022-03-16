package com.example.foodInventoryService.rabbitmq;

import lombok.Data;

@Data
public class RestaurantDTO {

    private String restaurantId;
    private String restaurantName;
    private String restaurantLocation;
}
