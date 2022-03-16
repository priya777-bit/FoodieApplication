package com.example.RestuarantManagementService.model;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Restaurant {

    @Id
    private String restaurantId;
    private String restaurantName;
    private String restaurantLocation;
    private List<Dish> dishList;
}
