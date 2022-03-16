package com.example.RestuarantManagementService.service;

import com.example.RestuarantManagementService.exception.DishAlreadyExist;
import com.example.RestuarantManagementService.exception.DishNotFound;
import com.example.RestuarantManagementService.exception.RestaurantAlreadyExist;
import com.example.RestuarantManagementService.exception.RestaurantNotFound;
import com.example.RestuarantManagementService.model.Dish;
import com.example.RestuarantManagementService.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    public Restaurant registerRestaurant(Restaurant restaurant) throws RestaurantAlreadyExist;
    public boolean removeRestaurant(String restaurantId) throws RestaurantNotFound;
    public Restaurant addDishToRestaurant(String restaurantId,Dish dish) throws RestaurantNotFound, DishAlreadyExist;
    public Restaurant removeDishFromRestaurant(String restaurantId, String dishId) throws RestaurantNotFound, DishNotFound;
    public List<Restaurant> findAllRestaurant();

}
