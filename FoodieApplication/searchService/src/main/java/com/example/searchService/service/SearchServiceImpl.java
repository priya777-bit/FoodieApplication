package com.example.searchService.service;

import com.example.searchService.model.Dish;
import com.example.searchService.model.Restaurant;
import com.example.searchService.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{

    private SearchRepository searchRepository;

    @Autowired
    public SearchServiceImpl(SearchRepository searchRepository)
    {
        this.searchRepository=searchRepository;
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return searchRepository.save(restaurant);
    }

    @Override
    public List<Dish> saveDish(String restaurantId, Dish dish) {
        Restaurant restaurant = searchRepository.findById(restaurantId).get();
        System.out.println(restaurant);
        List<Dish> dishList = restaurant.getDishList();
        if(dishList!=null) {
            for (Dish d : dishList) {
                if (d.getDishId().equalsIgnoreCase(dish.getDishId())) {
                    return null;
                } else {
                    List<Dish> dishList1 = new ArrayList<>(restaurant.getDishList());
                    dishList1.add(dish);
                    dishList=dishList1;
                }
            }
            restaurant.setDishList(dishList);
        }
        else
        {
            restaurant.setDishList(Arrays.asList(dish));
        }
        searchRepository.save(restaurant);
        return dishList;
    }

    @Override
    public List<Restaurant> findByRestaurantName(String restaurantName) {

        List<Restaurant> restaurants = searchRepository.findByRestaurantName(restaurantName);
        List<Restaurant> restaurantList = new ArrayList<>();
        for(Restaurant restaurant:restaurants)
        {
            String rest = restaurant.getRestaurantName();
            if (rest.equalsIgnoreCase(restaurantName))
                restaurantList = searchRepository.findByRestaurantName(rest);
        }

        return restaurantList;
    }

    @Override
    public List<Restaurant> findAllRestaurantFromDishName(String dishName) {

        System.out.println(dishName);
        return searchRepository.findAllRestaurantFromDishName(dishName);
    }
}
