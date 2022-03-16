package com.example.foodInventoryService.service;

import com.example.foodInventoryService.model.Dish;
import com.example.foodInventoryService.model.Restaurant;

import java.util.List;

public interface FoodService {

    public Restaurant saveRestaurant(Restaurant restaurant);
    public List<Dish> saveDish(String restaurantId,Dish dish);
}
