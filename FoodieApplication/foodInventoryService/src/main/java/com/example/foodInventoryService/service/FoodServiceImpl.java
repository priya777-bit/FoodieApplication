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
        System.out.println(restaurant);

        List<Dish> dishList = restaurant.getDishList();
        if(dishList!=null) {

            List<Dish> dishList1 = new ArrayList<>(restaurant.getDishList());
            dishList1.add(dish);
            dishList = dishList1;
            restaurant.setDishList(dishList);
        }
        else
        {
            System.out.println("listsavedagain");
            restaurant.setDishList(Arrays.asList(dish));
        }
        System.out.println("return");
        foodRepository.save(restaurant);
        return dishList;

//        List<Dish> dishList = restaurant.getDishList();
//        System.out.println("restaurant");
//                    List<Dish> dishList1 = new ArrayList<>(restaurant.getDishList());
//                    dishList1.add(dish);
//                    dishList=dishList1;
//        System.out.println("restaurant");
//                    restaurant.setDishList(dishList);
//
//        foodRepository.save(restaurant);
//        return dishList;
    }

    @Override
    public List<Restaurant> getAllData() {
        return foodRepository.findAll();
    }

    @Override
    public List<Dish> getDishData(String restaurantId) {
        Restaurant restaurant=foodRepository.findById(restaurantId).get();
        List<Dish> dishList=restaurant.getDishList();
        return dishList;
    }
}
