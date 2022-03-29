package com.example.addRestuarantService.repository;


import com.example.addRestuarantService.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant,String> {

   public List<Restaurant> findAllRestaurantByStatus(String status);

//    @Query( fields = "{ 'restaurantId' : 1 }")
//    public String findByRestaurantNameAndRestaurantLocation(String restaurantName,String restaurantLocation);

}