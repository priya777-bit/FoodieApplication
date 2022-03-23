package com.example.searchService.repository;

import com.example.searchService.model.Dish;
import com.example.searchService.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends MongoRepository<Restaurant,String>{

    List<Restaurant> findByRestaurantName(String restaurantName);

//    @Query(value = "{ 'dishList': { $elemMatch: { 'dishName' } }}")
//    List<Dish> findByDishName(String dishName);

<<<<<<< HEAD
    @Query("{'dishList.dishName':{$in:[?0]}}")
    List<Restaurant> findAllRestaurantFromDishName(String dishName);
=======
    @Query("{'dishList.dishName' : { $in : [?0]}}")
    List<Dish> findByDishName(String dishName);
>>>>>>> 9ba26d499f4551cb43dc21cf2b336e06e10c97bf
}
