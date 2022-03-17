package com.example.foodInventoryService.controller;

import com.example.foodInventoryService.model.Dish;
import com.example.foodInventoryService.model.Restaurant;
import com.example.foodInventoryService.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/inventory")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/restaurant")
    public ResponseEntity<?> saveRestaurant(@RequestBody Restaurant restaurant)
    {
        try
        {
            return new ResponseEntity<>(foodService.saveRestaurant(restaurant), HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Try Again After Some Time ..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{restaurantId}")
    public ResponseEntity<?> saveDish(@PathVariable String restaurantId, @RequestBody Dish dish)
    {
        try
        {
            return new ResponseEntity<>(foodService.saveDish(restaurantId,dish),HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Try Again Some Time ..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
