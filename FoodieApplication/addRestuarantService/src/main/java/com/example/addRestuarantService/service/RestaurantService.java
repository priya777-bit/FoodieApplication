package com.example.addRestuarantService.service;

import com.example.addRestuarantService.model.Dish;
import com.example.addRestuarantService.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    public Restaurant addRestaurant(Restaurant restaurant);
    public Restaurant addDish(String restaurantId,Dish dish);

    public List<Restaurant> findAllRestaurantByStatus(String status);

<<<<<<< HEAD
    public List<Restaurant> findAllRestaurant();
=======
    //public List<Restaurant> findAllRestaurant();
>>>>>>> 2bae6d81d8ef16b1b7dc4f8834e1d5cb2917bf1b


    public boolean deleteRestaurantWhenRejected(String restaurantId);

//    public boolean deleteRestaurantWhenRejected(String restaurantId,String status);
//    public String findByRestaurantNameAndRestaurantLocation(String restaurantName,String restaurantLocation);


<<<<<<< HEAD
//    public boolean deleteRestaurantWhenRejected(String restaurantId);
=======
   // public boolean deleteRestaurantWhenRejected(String restaurantId);
>>>>>>> 2bae6d81d8ef16b1b7dc4f8834e1d5cb2917bf1b
   // public String findByRestaurantNameAndRestaurantLocation(String restaurantName,String restaurantLocation);
    public List<Dish> findAllDishByRestaurantId(String restaurantId);

    public Restaurant updateRestaurantWhenApprove(Restaurant restaurant,String status);
    public Dish updateDishWhenApprove(String restaurantId ,Dish dish,String dishStatus);

}
