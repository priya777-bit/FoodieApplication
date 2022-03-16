package com.example.RestuarantManagementService.service;

import com.example.RestuarantManagementService.exception.DishAlreadyExist;
import com.example.RestuarantManagementService.exception.DishNotFound;
import com.example.RestuarantManagementService.exception.RestaurantAlreadyExist;
import com.example.RestuarantManagementService.exception.RestaurantNotFound;
import com.example.RestuarantManagementService.model.Dish;
import com.example.RestuarantManagementService.model.Restaurant;
import com.example.RestuarantManagementService.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant registerRestaurant(Restaurant restaurant) throws RestaurantAlreadyExist {
        if(restaurantRepository.findById(restaurant.getRestaurantId()).isPresent()){
            throw new RestaurantAlreadyExist();
        }

        return restaurantRepository.save(restaurant);
    }

    @Override
    public boolean removeRestaurant(String restaurantId) throws RestaurantNotFound {
        boolean result = false;
        if(restaurantRepository.findById(restaurantId).isEmpty()){
            throw new RestaurantNotFound();
        }
        else {
            Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
            restaurantRepository.delete(restaurant);
            result = true;
        }
        return result;
    }

    @Override
    public Restaurant addDishToRestaurant(String restaurantId, Dish dish) throws RestaurantNotFound, DishAlreadyExist {
        if(restaurantRepository.findById(restaurantId).isEmpty()){
            throw new RestaurantNotFound();
        }
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        List<Dish> dishList = restaurant.getDishList();
        if(dishList==null){
            restaurant.setDishList(Arrays.asList(dish));
        }
        else{
            if(dishList.get(0).equals(dish.getDishId())){
                throw new DishAlreadyExist();
            }
            dishList.add(dish);
            restaurant.setDishList(dishList);
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant removeDishFromRestaurant(String restaurantId,String dishId) throws RestaurantNotFound,DishNotFound {

        Restaurant restaurant = null;
        boolean dishIdPresent = false;

        if(restaurantRepository.findById(restaurantId).isEmpty()){
            throw new RestaurantNotFound();
        }
        else {
            restaurant = restaurantRepository.findById(restaurantId).get();
            List<Dish> dishList = restaurant.getDishList();
            dishIdPresent = dishList.removeIf(t -> t.getDishId().equals(dishId));
            if (!dishIdPresent) {
                throw new DishNotFound();
            }
            restaurant.setDishList(dishList);
            return restaurantRepository.save(restaurant);
        }
    }

    @Override
    public List<Restaurant> findAllRestaurant() {
        return restaurantRepository.findAll();
    }

}
