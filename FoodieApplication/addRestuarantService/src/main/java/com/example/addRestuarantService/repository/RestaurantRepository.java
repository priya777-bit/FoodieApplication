package com.example.addRestuarantService.repository;


import com.example.addRestuarantService.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant,String> {

    @Query( fields = "{ 'restaurantId' : 1 }")
    public String findByRestaurantNameAndRestaurantLocation(String restaurantName,String restaurantLocation);

}