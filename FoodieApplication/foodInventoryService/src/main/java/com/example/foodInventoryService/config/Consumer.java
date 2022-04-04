package com.example.foodInventoryService.config;

import com.example.foodInventoryService.model.Dish;
import com.example.foodInventoryService.model.Restaurant;
import com.example.foodInventoryService.rabbitmq.DishDTO;
import com.example.foodInventoryService.rabbitmq.RestaurantDTO;
import com.example.foodInventoryService.service.FoodService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Consumer {

    @Autowired
    private FoodService foodService;

    @RabbitListener(queues = "inventory_rest_queue")
    public void getRestaurantDTOFromRabbitMq(RestaurantDTO restaurantDTO)
    {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(restaurantDTO.getRestaurantId());
        restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
        restaurant.setRestaurantLocation(restaurant.getRestaurantLocation());

        foodService.saveRestaurant(restaurant);
    }

    @RabbitListener(queues = "inventory_dish_queue")
    public void getDishDTOFromRabbitMq(DishDTO dishDTO)
    {
        Dish dish = new Dish();
        dish.setDishId(dishDTO.getDishId());
        dish.setDishName(dishDTO.getDishName());
        dish.setDishType(dishDTO.getDishType());

        foodService.saveDish(dishDTO.getRestaurantId(),dish);
    }
}
