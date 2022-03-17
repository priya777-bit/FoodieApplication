package com.example.addRestuarantService.service;

import com.example.addRestuarantService.model.Dish;
import com.example.addRestuarantService.model.Restaurant;

public interface RestaurantService {

    public void addRestaurant(Restaurant restaurant);
    public void addDish(String restaurantId,Dish dish);
}
