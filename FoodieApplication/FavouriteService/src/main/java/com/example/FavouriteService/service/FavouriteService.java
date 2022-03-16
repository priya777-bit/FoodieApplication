package com.example.FavouriteService.service;

import com.example.FavouriteService.model.Favourite;

import java.util.List;

public interface FavouriteService {
    Favourite addFavourite(Favourite favourite);
    List<Favourite> getALlFavourite(String userMailId);
}
