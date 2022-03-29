package com.example.addRestuarantService.model;

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
<<<<<<< HEAD
    private String dishStatus = "reject";

    public Dish(String dishId, String dishName, String dishType) {
    }
=======

>>>>>>> b840cb22b92bec9b2129e91d83715e410df79aa3
}
