package com.example.RestuarantManagementService.rabbitMq;

import lombok.Data;

@Data
public class DishDTO {

    private String dishId;
    private String restaurantId;
    private String dishName;
    private String dishType;
}
