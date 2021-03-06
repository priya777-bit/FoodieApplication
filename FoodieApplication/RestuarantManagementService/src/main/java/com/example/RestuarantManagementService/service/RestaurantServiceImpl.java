package com.example.RestuarantManagementService.service;

import com.example.RestuarantManagementService.exception.DishAlreadyExist;
import com.example.RestuarantManagementService.exception.DishNotFound;
import com.example.RestuarantManagementService.exception.RestaurantAlreadyExist;
import com.example.RestuarantManagementService.exception.RestaurantNotFound;
import com.example.RestuarantManagementService.model.Dish;
import com.example.RestuarantManagementService.model.Restaurant;
import com.example.RestuarantManagementService.producerConfig.Producer;
import com.example.RestuarantManagementService.rabbitMq.DishDTO;
import com.example.RestuarantManagementService.rabbitMq.RestaurantDTO;
import com.example.RestuarantManagementService.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    private RestaurantRepository restaurantRepository;

    @Autowired
    private Producer producer;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant registerRestaurant(Restaurant restaurant) throws RestaurantAlreadyExist {
        if(restaurantRepository.findById(restaurant.getRestaurantId()).isPresent()){
            throw new RestaurantAlreadyExist();
        }
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setRestaurantId(restaurant.getRestaurantId());
        restaurantDTO.setRestaurantName(restaurant.getRestaurantName());
        restaurantDTO.setRestaurantLocation(restaurant.getRestaurantLocation());
        producer.sendMessageToRabbit(restaurantDTO);
        //boolean status = Boolean.parseBoolean(restaurantRepository.save(restaurant).getStatus());
        if(restaurant.getStatus().equalsIgnoreCase("reject")){
            restaurant.setStatus("approve");
            restaurantRepository.save(restaurant);
        }
        else{

        }
        return restaurant;
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
        dish.setDishStatus("approve");
        List<Dish> dishList = restaurant.getDishList();
        DishDTO dishDTO = new DishDTO();
        if(dishList!=null) {
            for (Dish d : dishList) {
                if (d.getDishId().equalsIgnoreCase(dish.getDishId())) {
                    throw new DishAlreadyExist();
                } else {
                    dishDTO.setDishId(dish.getDishId());
                    dishDTO.setDishName(dish.getDishName());
                    dishDTO.setDishType(dish.getDishType());
                    dishDTO.setRestaurantId(restaurantId);
                    List<Dish> dishList1 = new ArrayList<>(restaurant.getDishList());
                    dishList1.add(dish);
                    dishList = dishList1;
                }
            }
            restaurant.setDishList(dishList);
        }
            else
            {
                System.out.println("listsavedagain");
                dishDTO.setDishId(dish.getDishId());
                dishDTO.setDishName(dish.getDishName());
                dishDTO.setDishType(dish.getDishType());
                dishDTO.setRestaurantId(restaurantId);
                restaurant.setDishList(Arrays.asList(dish));
            }
            System.out.println("return");
        producer.sendMessageToRabbitMQ(dishDTO);
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
