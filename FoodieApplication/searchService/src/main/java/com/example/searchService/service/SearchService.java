package com.example.searchService.service;

import com.example.searchService.model.Dish;
import com.example.searchService.model.Restaurant;

import java.util.List;

public interface SearchService {

    public Restaurant saveRestaurant(Restaurant restaurant);
    public List<Dish> saveDish(String restaurantId,Dish dish);
    public List<Restaurant> findByRestaurantName(String restaurantName);
    public List<Dish> findAllRestaurantFromDishName(String dishName);
}
