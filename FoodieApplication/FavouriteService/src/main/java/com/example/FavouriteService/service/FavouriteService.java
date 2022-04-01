package com.example.FavouriteService.service;

import com.example.FavouriteService.exception.FavouriteAlreadyExist;
import com.example.FavouriteService.model.Dish;
import com.example.FavouriteService.model.Favourite;
import com.example.FavouriteService.model.Image;
import com.example.FavouriteService.model.Restaurant;

import java.util.List;

public interface FavouriteService {
    Favourite addFavourite(Favourite favourite) throws FavouriteAlreadyExist;
    List<Favourite> getALlFavourite(String userMailId);
    boolean removeFromFav(String favouriteId);
    boolean removeDishFromFav(String favouriteId,String restaurantId,String dishId);
    List<Dish> addDishToFav(String favouriteId,String restaurantId, Dish dish);
}
