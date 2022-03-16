package com.example.searchService.service;

import com.example.searchService.model.Dish;
import com.example.searchService.model.Restaurant;
import com.example.searchService.repository.SearchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{

    private SearchRepository searchRepository;

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
        List<Dish> dishList = new ArrayList<>();
        dishList.add(dish);
        restaurant.setDishList(dishList);
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
