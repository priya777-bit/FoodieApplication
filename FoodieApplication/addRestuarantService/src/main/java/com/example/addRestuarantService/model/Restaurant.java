package com.example.addRestuarantService.model;

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
public class Restaurant {

    @Id
    private String restaurantId;
    private String restaurantName;
    private String restaurantLocation;
    private List<Dish> dishList;
    private String status = "reject";

<<<<<<< HEAD
    public Restaurant(String restaurantId, String restaurantName, String restaurantLocation, List<Dish> dishList) {
    }
=======

//    public Restaurant(String r001, String leaves, String nasik, List<Dish> dishList) {
//    }
//    public Restaurant(String restaurantId, String restaurantName, String restaurantLocation, List<Dish> dishList) {
//    }

    public Restaurant(String restaurantId, String restaurantName, String restaurantLocation, List<Dish> dishList) {
    }

>>>>>>> 6db9e26f3effcfb998c101096dc0324145f6893b
}
