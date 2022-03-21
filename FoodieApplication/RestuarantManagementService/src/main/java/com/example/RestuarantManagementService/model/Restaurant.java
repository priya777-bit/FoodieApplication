package com.example.RestuarantManagementService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    private String restaurantId;
    private String restaurantName;
    private String restaurantLocation;
    private List<Dish> dishList;
}
