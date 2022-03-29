package com.example.RestuarantManagementService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {

    private String dishId;
    private String dishName;
    private String dishType;
    private String dishStatus = "reject";

    public Dish(String dishId, String dishName, String dishType) {
    }
}
