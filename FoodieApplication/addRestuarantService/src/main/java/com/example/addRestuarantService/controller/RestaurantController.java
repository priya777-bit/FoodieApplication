package com.example.addRestuarantService.controller;


import com.example.addRestuarantService.model.Dish;
import com.example.addRestuarantService.model.Restaurant;
import com.example.addRestuarantService.service.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/request")
public class RestaurantController {

    private RestaurantServiceImpl restaurantService;

    @Autowired
    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/restaurant")
    public ResponseEntity<?> addRestaurant(@RequestBody Restaurant restaurant){
        try
        {
            return new ResponseEntity<>(restaurantService.addRestaurant(restaurant),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("try again some time ..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{restaurantId}/dish")
    public ResponseEntity<?> addDish(@PathVariable String  restaurantId, @RequestBody Dish dish){
        try {
            return new ResponseEntity<>(restaurantService.addDish(restaurantId,dish),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("try again some time ..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/restaurant/find")
    public ResponseEntity<?> findAllRestaurant(){
        try {
            return new ResponseEntity<>(restaurantService.findAllRestaurant(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Try After Some Time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
