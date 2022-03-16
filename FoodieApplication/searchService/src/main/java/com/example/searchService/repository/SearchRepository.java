package com.example.searchService.repository;

import com.example.searchService.model.Dish;
import com.example.searchService.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends MongoRepository<Restaurant,String> {

    List<Restaurant> findByRestaurantName(String restaurantName);
    List<Dish> findByDishName(String dishName);
}
