package com.example.addRestuarantService.service;

import com.example.addRestuarantService.config.Producer;
import com.example.addRestuarantService.model.Dish;
import com.example.addRestuarantService.model.Restaurant;
import com.example.addRestuarantService.rabbitmq.DishDTO;
import com.example.addRestuarantService.rabbitmq.RestaurantDTO;
import com.example.addRestuarantService.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private Producer producer;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setRestaurantId(restaurant.getRestaurantId());
        restaurantDTO.setRestaurantName(restaurant.getRestaurantName());
        restaurantDTO.setRestaurantLocation(restaurant.getRestaurantLocation());

        producer.sendRestMsg2RabbitMq(restaurantDTO);
        System.out.println(restaurant);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant addDish(String restaurantId,Dish dish) {

        DishDTO dishDTO = new DishDTO();
        dishDTO.setDishId(dish.getDishId());
        dishDTO.setDishName(dish.getDishName());
        dishDTO.setDishType(dish.getDishType());
        dishDTO.setRestaurantId(restaurantId);

        producer.sendDishMsg2RabbitMq(dishDTO);
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        List<Dish> dishList = restaurant.getDishList();

        if(dishList!=null){
            dishList.add(dish);
            restaurant.setDishList(dishList);
        }
        else
        {
            restaurant.setDishList(Arrays.asList(dish));
        }
        return restaurantRepository.save(restaurant);

    }

    @Override
    public List<Restaurant> findAllRestaurantByStatus(String status) {
       return restaurantRepository.findAllRestaurantByStatus(status);
    }

    @Override
    public List<Restaurant> findAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public boolean deleteRestaurantWhenRejected(String restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        restaurantRepository.delete(restaurant);
        return true;
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

>>>>>>> 2bae6d81d8ef16b1b7dc4f8834e1d5cb2917bf1b
>>>>>>> 6db9e26f3effcfb998c101096dc0324145f6893b
    @Override
    public List<Dish> findAllDishByRestaurantId(String restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        List<Dish> dishList = restaurant.getDishList();
        System.out.println(restaurant);
        return dishList;
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

>>>>>>> 2bae6d81d8ef16b1b7dc4f8834e1d5cb2917bf1b
>>>>>>> 6db9e26f3effcfb998c101096dc0324145f6893b
    @Override
    public Restaurant updateRestaurantWhenApprove(Restaurant restaurant ,String status) {
        restaurant.setStatus(status);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Dish updateDishWhenApprove(String restaurantId ,Dish dish, String dishStatus) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        List<Dish>dishList = restaurant.getDishList();
        Dish dish1 = null;
        for(int i =0;i<dishList.size();i++) {
            dish1 = dishList.get(i);
            if (dish.getDishId().equalsIgnoreCase(dish1.getDishId())) {
                dish1.setDishStatus(dishStatus);
                System.out.println(dish1);
                restaurantRepository.save(restaurant);
            }
        }
        System.out.println("return dish"+dish1);

        return dish1;
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

>>>>>>> 2bae6d81d8ef16b1b7dc4f8834e1d5cb2917bf1b
>>>>>>> 6db9e26f3effcfb998c101096dc0324145f6893b
//    @Override
//    public String findByRestaurantNameAndRestaurantLocation(String restaurantName, String restaurantLocation){
//        String id = restaurantRepository.findByRestaurantNameAndRestaurantLocation(restaurantName,restaurantLocation);
//        return id;
//    }
}
