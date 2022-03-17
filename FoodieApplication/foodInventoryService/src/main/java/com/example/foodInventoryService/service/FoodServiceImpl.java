package com.example.foodInventoryService.service;

import com.example.foodInventoryService.model.Dish;
import com.example.foodInventoryService.model.Restaurant;
import com.example.foodInventoryService.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{

    private FoodRepository foodRepository;

    @Autowired
    public  FoodServiceImpl(FoodRepository foodRepository)
    {
        this.foodRepository=foodRepository;
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return foodRepository.save(restaurant);
    }

    @Override
    public List<Dish> saveDish(String restaurantId, Dish dish) {
        Restaurant restaurant = foodRepository.findById(restaurantId).get();

        List<Dish> dishList = restaurant.getDishList();

                    List<Dish> dishList1 = new ArrayList<>(restaurant.getDishList());
                    dishList1.add(dish);
                    dishList=dishList1;
                    restaurant.setDishList(dishList);

        foodRepository.save(restaurant);
        return dishList;
    }
}
