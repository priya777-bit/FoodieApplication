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
//        System.out.println(dishList);
//        List<Dish> dishList1 = new ArrayList<>(dishList);
//        System.out.println("in 34");
//        //dishList.add(dish);
//       // dishList=dishList;
//        restaurant.setDishList(Arrays.asList(dish));
//        System.out.println("in 37");
//        //restaurant.setDishList(dishList);
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
            System.out.println("listsavedagain");
            restaurant.setDishList(Arrays.asList(dish));
        }
        searchRepository.save(restaurant);
        return dishList;
    }

    @Override
    public List<Restaurant> findByRestaurantName(String restaurantName) {
        return searchRepository.findByRestaurantName(restaurantName);
    }

    @Override
    public List<Dish> findByDishName(String dishName) {
        return searchRepository.findByDishName(dishName);
    }
}
