package com.example.searchService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Restaurant {

    @Id
    private String restaurantId;
    private String restaurantName;
    private String restaurantLocation;
    private List<Dish> dishList;
}
