package com.example.addRestuarantService.repository;


import com.example.addRestuarantService.model.Dish;
import com.example.addRestuarantService.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant,String> {

//    @Query()
//    public List<Dish> findAllDishByRestaurantList(List<Restaurant> restaurantList);

//    @Query( fields = "{ 'restaurantId' : 1 }")
//    public String findByRestaurantNameAndRestaurantLocation(String restaurantName,String restaurantLocation);

}