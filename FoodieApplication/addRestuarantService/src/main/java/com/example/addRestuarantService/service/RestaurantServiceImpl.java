package com.example.addRestuarantService.service;

import com.example.addRestuarantService.config.Producer;
import com.example.addRestuarantService.model.Dish;
import com.example.addRestuarantService.model.Restaurant;
import com.example.addRestuarantService.rabbitmq.DishDTO;
import com.example.addRestuarantService.rabbitmq.RestaurantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private Producer producer;

    @Override
    public void addRestaurant(Restaurant restaurant) {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setRestaurantId(restaurant.getRestaurantId());
        restaurantDTO.setRestaurantName(restaurant.getRestaurantName());
        restaurantDTO.setRestaurantLocation(restaurant.getRestaurantLocation());

        producer.sendRestMsg2RabbitMq(restaurantDTO);
    }

    @Override
    public void addDish(String restaurantId,Dish dish) {

        DishDTO dishDTO = new DishDTO();
        dishDTO.setDishId(dish.getDishId());
        dishDTO.setDishName(dish.getDishName());
        dishDTO.setDishType(dish.getDishType());
        dishDTO.setRestaurantId(restaurantId);
        producer.sendDishMsg2RabbitMq(dishDTO);
    }
}
