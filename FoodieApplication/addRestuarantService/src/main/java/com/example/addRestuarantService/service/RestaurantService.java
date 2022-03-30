package com.example.addRestuarantService.service;

import com.example.addRestuarantService.model.Dish;
import com.example.addRestuarantService.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    public Restaurant addRestaurant(Restaurant restaurant);
    public Restaurant addDish(String restaurantId,Dish dish);

    public List<Restaurant> findAllRestaurantByStatus(String status);

    public List<Restaurant> findAllRestaurant();


    public boolean deleteRestaurantWhenRejected(String restaurantId);

//    public boolean deleteRestaurantWhenRejected(String restaurantId,String status);
//    public String findByRestaurantNameAndRestaurantLocation(String restaurantName,String restaurantLocation);


//    public boolean deleteRestaurantWhenRejected(String restaurantId);
   // public String findByRestaurantNameAndRestaurantLocation(String restaurantName,String restaurantLocation);
    public List<Dish> findAllDishByRestaurantId(String restaurantId);

    public Restaurant updateRestaurantWhenApprove(Restaurant restaurant,String status);
    public Dish updateDishWhenApprove(String restaurantId ,Dish dish,String dishStatus);

}
