package com.example.searchService.rabbitmq;

import lombok.Data;

@Data
public class DishDTO {

    private String restaurantId;
    private String dishId;
    private String dishName;
    private String dishType;
}
