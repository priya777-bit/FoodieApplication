package com.example.foodInventoryService.controller;

import com.example.foodInventoryService.model.Dish;
//import com.example.foodInventoryService.model.Image;
import com.example.foodInventoryService.model.Restaurant;
import com.example.foodInventoryService.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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
            List<Dish> dishList=foodService.getDishData(restaurantId);
//            for(int i=0;i<dishList.size();i++) {
//                dishList.get(i).setImage(getFile(dishList.get(i).getDishId()));
//            }
            return new ResponseEntity<>(dishList,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Try Again Some Time ..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/restaurant/{filename}")
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        List<String> images = foodService.load(filename);
        return new ResponseEntity<>(images,HttpStatus.OK);
    }
}
