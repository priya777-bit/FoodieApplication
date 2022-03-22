package com.example.addRestuarantService.service;

import com.example.addRestuarantService.model.Dish;
import com.example.addRestuarantService.model.Restaurant;

public interface RestaurantService {

    public boolean addRestaurant(Restaurant restaurant);
    public boolean addDish(String restaurantId,Dish dish);
}
