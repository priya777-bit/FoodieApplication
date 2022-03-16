package com.example.foodInventoryService.repository;

import com.example.foodInventoryService.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends MongoRepository<Restaurant,String > {
}
