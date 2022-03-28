package com.example.foodInventoryService.controller;

import com.example.foodInventoryService.model.Dish;
import com.example.foodInventoryService.model.Restaurant;
import com.example.foodInventoryService.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{restaurantId}")
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
    @GetMapping("/getAllData")
    public ResponseEntity<?> getALlData()
    {
        try
        {
            return new ResponseEntity<>(foodService.getAllData(),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Try Again Some Time ..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getDishesData/{restaurantId}")
    public ResponseEntity<?> getDishesData(@PathVariable String restaurantId)
    {
        try
        {
            return new ResponseEntity<>(foodService.getDishData(restaurantId),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Try Again Some Time ..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
