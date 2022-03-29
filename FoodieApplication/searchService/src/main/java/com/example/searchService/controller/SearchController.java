package com.example.searchService.controller;

import com.example.searchService.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/v1/search")
public class SearchController {
    
    private SearchService searchService;
    
    @Autowired
    public SearchController(SearchService searchService)
    {
        this.searchService=searchService;
    }

    @GetMapping("/rest/{restaurantName}")
    public ResponseEntity<?> findByRestaurantName(@PathVariable String restaurantName)
    {
        try
        {
            return new ResponseEntity<>(searchService.findByRestaurantName(restaurantName), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Try Again After Some Time ..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/dish/{dishName}")
    public ResponseEntity<?> findAllRestaurantFromDishName(@PathVariable String dishName)
    {
        System.out.println(dishName);
        try
        {
            return new ResponseEntity<>(searchService.findAllRestaurantFromDishName(dishName),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Try Again After Some Time ..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
