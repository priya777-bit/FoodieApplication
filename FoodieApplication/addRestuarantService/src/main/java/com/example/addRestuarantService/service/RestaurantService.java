package com.example.addRestuarantService.service;

import com.example.addRestuarantService.model.Dish;
import com.example.addRestuarantService.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    public Restaurant addRestaurant(Restaurant restaurant);
    public Restaurant addDish(String restaurantId,Dish dish);
    public List<Restaurant> findAllRestaurant();
<<<<<<< HEAD

    public boolean deleteRestaurantWhenRejected(String restaurantId);

//    public boolean deleteRestaurantWhenRejected(String restaurantId,String status);
//    public String findByRestaurantNameAndRestaurantLocation(String restaurantName,String restaurantLocation);

=======
    public boolean deleteRestaurantWhenRejected(String restaurantId);
   // public boolean deleteRestaurantWhenRejected(String restaurantId,String status);
   // public String findByRestaurantNameAndRestaurantLocation(String restaurantName,String restaurantLocation);
    public List<Dish> findAllDishByRestaurantId(String restaurantId);
>>>>>>> c7255009cf9e2407eb1546240a46198fe3fc1eba
}
