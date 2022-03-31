package com.example.FavouriteService.service;

import com.example.FavouriteService.model.Favourite;
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
    public Favourite addFavourite(Favourite favourite) {
        Favourite favourite1=null;
        String id = favourite.getFavouriteId();
        System.out.println(id);
        System.out.println(favourite);
        if(!favouriteRepository.existsById(favourite.getFavouriteId()))
        {
             favourite1= favouriteRepository.save(favourite);
        }
        return favourite1;
    }

    @Override
    public List<Favourite> getALlFavourite(String userMailId) {
        return favouriteRepository.findByUserMailId(userMailId);
    }
}
