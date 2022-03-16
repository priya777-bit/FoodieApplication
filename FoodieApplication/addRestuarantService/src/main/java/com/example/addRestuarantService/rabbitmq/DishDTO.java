package com.example.addRestuarantService.rabbitmq;

import lombok.Data;

@Data
public class DishDTO {

    private String dishId;
    private String dishName;
    private String dishType;
}
