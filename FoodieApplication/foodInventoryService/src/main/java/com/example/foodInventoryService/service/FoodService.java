package com.example.foodInventoryService.service;

import com.example.foodInventoryService.model.Dish;
import com.example.foodInventoryService.model.Image;
import com.example.foodInventoryService.model.Restaurant;
import org.springframework.core.io.Resource;

import java.util.List;

public interface FoodService {

    public Restaurant saveRestaurant(Restaurant restaurant);
    public List<Dish> saveDish(String restaurantId,Dish dish);
    public List<Restaurant> getAllData();
    public List<Dish> getDishData(String restaurantId);
    public List<Image> load(String filename);
}
