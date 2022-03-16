package com.example.RestuarantManagementService.config;


import com.example.RestuarantManagementService.exception.DishAlreadyExist;
import com.example.RestuarantManagementService.exception.RestaurantAlreadyExist;
import com.example.RestuarantManagementService.exception.RestaurantNotFound;
import com.example.RestuarantManagementService.model.Dish;
import com.example.RestuarantManagementService.model.Restaurant;
import com.example.RestuarantManagementService.rabbitMq.DishDTO;
import com.example.RestuarantManagementService.rabbitMq.RestaurantDTO;
import com.example.RestuarantManagementService.service.RestaurantServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Consumer {

    @Autowired
    private RestaurantServiceImpl restaurantService;

    @RabbitListener(queues = "rest_queue")
    public void getRestaurantDTOFromRabbitMQ(RestaurantDTO restaurantDTO) throws RestaurantAlreadyExist{
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(restaurantDTO.getRestaurantId());
        restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
        restaurant.setRestaurantLocation(restaurantDTO.getRestaurantLocation());
        restaurantService.registerRestaurant(restaurant);
    }

    @RabbitListener(queues = "dish_queue")
    public void getDishDTOFromRabbitMQ(Restaurant restaurant,DishDTO dishDTO) throws RestaurantNotFound, DishAlreadyExist {
        Dish dish = new Dish();
        dish.setDishId(dishDTO.getDishId());
        dish.setDishName(dishDTO.getDishName());
        dish.setDishType(dish.getDishType());
        List<Dish> dishList = new ArrayList<>();
        dishList.add(dish);
        restaurant.setDishList(dishList);
        restaurantService.addDishToRestaurant(restaurant.getRestaurantId(),dish);
    }
}
