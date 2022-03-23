package com.example.RestuarantManagementService.controller;

import com.example.RestuarantManagementService.exception.DishAlreadyExist;
import com.example.RestuarantManagementService.exception.DishNotFound;
import com.example.RestuarantManagementService.exception.RestaurantAlreadyExist;
import com.example.RestuarantManagementService.exception.RestaurantNotFound;
import com.example.RestuarantManagementService.model.Dish;
import com.example.RestuarantManagementService.model.Restaurant;
import com.example.RestuarantManagementService.service.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/user/admin")
public class RestaurantController {

    private RestaurantServiceImpl restaurantService;

    @Autowired
    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/restaurant/save")
    public ResponseEntity<?> registerRestaurant(@RequestBody Restaurant restaurant) throws RestaurantAlreadyExist{
        try {
            return new ResponseEntity<>(restaurantService.registerRestaurant(restaurant), HttpStatus.CREATED);
        }
        catch (RestaurantAlreadyExist e){
            throw new RestaurantAlreadyExist();
        }
        catch (Exception e){
            return new ResponseEntity<>("Try After SomeTime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public ResponseEntity<?> removeRestaurant(@PathVariable String restaurantId) throws RestaurantNotFound{
        try{
            return new ResponseEntity<>(restaurantService.removeRestaurant(restaurantId),HttpStatus.OK);
        }
        catch (RestaurantNotFound e){
            e.printStackTrace();
            return new ResponseEntity<>("Try After SomeTime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/restaurant/{restaurantId}/dish")
    public ResponseEntity<?> addDishToRestaurant(@PathVariable String restaurantId, @RequestBody Dish dish) throws RestaurantNotFound, DishAlreadyExist{
        try {
            return new ResponseEntity<>(restaurantService.addDishToRestaurant(restaurantId,dish),HttpStatus.CREATED);
        }
        catch (RestaurantNotFound e){
            throw new RestaurantNotFound();
        }
        catch (DishAlreadyExist e){
            throw new DishAlreadyExist();
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Try After SomeTime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/restaurant/{restaurantId}/dish/{dishId}")
    public ResponseEntity<?> removeDishFromRestaurant(@PathVariable String restaurantId,@PathVariable String dishId) throws RestaurantNotFound, DishNotFound{
        try {
            return new ResponseEntity<>(restaurantService.removeDishFromRestaurant(restaurantId,dishId),HttpStatus.OK);
        }
        catch (RestaurantNotFound e){
            throw new RestaurantNotFound();
        }
        catch (DishNotFound e){
            throw new DishNotFound();
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Try After SomeTime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/restaurant/find")
    public ResponseEntity<?> findAllRestaurant(){
        try {
            return new ResponseEntity<>(restaurantService.findAllRestaurant(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Try After SomeTime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
