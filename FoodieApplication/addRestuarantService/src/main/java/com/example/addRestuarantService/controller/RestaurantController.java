package com.example.addRestuarantService.controller;


import com.example.addRestuarantService.model.Dish;
import com.example.addRestuarantService.model.Restaurant;
import com.example.addRestuarantService.service.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/request")
public class RestaurantController {

    private RestaurantServiceImpl restaurantService;

    @Autowired
    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/restaurant")
    public void addRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.addRestaurant(restaurant);
    }

    @PostMapping("/{restaurantId}/dish")
    public void addDish(@PathVariable String  restaurantId, @RequestBody Dish dish){
        try {
            restaurantService.addDish(restaurantId,dish);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
