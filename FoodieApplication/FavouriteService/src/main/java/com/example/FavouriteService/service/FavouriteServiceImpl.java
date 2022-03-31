package com.example.FavouriteService.service;

import com.example.FavouriteService.exception.FavouriteAlreadyExist;
import com.example.FavouriteService.model.Favourite;
import com.example.FavouriteService.model.Restaurant;
import com.example.FavouriteService.repository.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteServiceImpl implements FavouriteService{

    private FavouriteRepository favouriteRepository;

    @Autowired
    public FavouriteServiceImpl(FavouriteRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }

    @Override
    public Favourite addFavourite(Favourite favourite) throws FavouriteAlreadyExist {

        if(favouriteRepository.findById(favourite.getFavouriteId()).isPresent())
        {
             throw new FavouriteAlreadyExist();
        }

        return favouriteRepository.save(favourite);
    }

    @Override
    public List<Favourite> getALlFavourite(String userMailId) {
        return favouriteRepository.findByUserMailId(userMailId);
    }

    @Override
    public boolean removeFromFav(String favouriteId) {
        boolean result = false;
        Favourite favourite = favouriteRepository.findById(favouriteId).get();

        if(favouriteRepository.findById(favouriteId).isPresent())
        {
            favouriteRepository.delete(favourite);
            result = true;
        }

        return result;
    }
}
