package com.example.addRestuarantService.service;

import com.example.addRestuarantService.model.Dish;
import com.example.addRestuarantService.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    public Restaurant addRestaurant(Restaurant restaurant);
    public Restaurant addDish(String restaurantId,Dish dish);
<<<<<<< HEAD
    public List<Restaurant> findAllRestaurantByStatus(String status);
=======
    public List<Restaurant> findAllRestaurant();
<<<<<<< HEAD

    public boolean deleteRestaurantWhenRejected(String restaurantId);

//    public boolean deleteRestaurantWhenRejected(String restaurantId,String status);
//    public String findByRestaurantNameAndRestaurantLocation(String restaurantName,String restaurantLocation);

=======
>>>>>>> b840cb22b92bec9b2129e91d83715e410df79aa3
    public boolean deleteRestaurantWhenRejected(String restaurantId);
   // public String findByRestaurantNameAndRestaurantLocation(String restaurantName,String restaurantLocation);
    public List<Dish> findAllDishByRestaurantId(String restaurantId);
<<<<<<< HEAD
    public Restaurant updateRestaurantWhenApprove(Restaurant restaurant,String status);
    public Dish updateDishWhenApprove(String restaurantId ,Dish dish,String dishStatus);
=======
>>>>>>> c7255009cf9e2407eb1546240a46198fe3fc1eba
>>>>>>> b840cb22b92bec9b2129e91d83715e410df79aa3
}
