package com.example.RestuarantManagementService.rabbitMq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {
    private String restaurantId;
    private String restaurantName;
    private String restaurantLocation;
}
