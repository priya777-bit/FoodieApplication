package com.example.searchService.config;

import com.example.searchService.model.Dish;
import com.example.searchService.model.Restaurant;
import com.example.searchService.rabbitmq.DishDTO;
import com.example.searchService.rabbitmq.RestaurantDTO;
import com.example.searchService.service.SearchService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Consumer {

    @Autowired
    private SearchService searchService;

    @RabbitListener(queues = "rest_queue")
    public void getRestaurantDTOFromRabbitMq(RestaurantDTO restaurantDTO)
    {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(restaurantDTO.getRestaurantId());
        restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
        restaurant.setRestaurantLocation(restaurantDTO.getRestaurantLocation());

        searchService.saveRestaurant(restaurant);
    }

    @RabbitListener(queues = "dish_queue")
    public void getDishDTOFromRabbitMq(Restaurant restaurant,DishDTO dishDTO)
    {
        Dish dish = new Dish();
        dish.setDishId(dish.getDishId());
        dish.setDishName(dishDTO.getDishName());
        dish.setDishType(dish.getDishType());

        List<Dish> dishList = new ArrayList<>();
        dishList.add(dish);
        restaurant.setDishList(dishList);
        searchService.saveDish(restaurant.getRestaurantId(),dish);
    }
}
