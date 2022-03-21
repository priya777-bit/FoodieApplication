package com.example.FavouriteService.controller;

import com.example.FavouriteService.model.Favourite;
import com.example.FavouriteService.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/users")
public class FavouriteController {

    private FavouriteService favouriteService;

    @Autowired
    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @PostMapping("/favourite/addFavourite")
    public ResponseEntity<?> addFavourite(@RequestBody Favourite favourite)
    {
        try
        {
            return new ResponseEntity<>(favouriteService.addFavourite(favourite), HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("try after some time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/favourite/getFavourite/{userMailId}")
    public ResponseEntity<?> getFavourite(@PathVariable String userMailId)
    {
        try
        {
            return new ResponseEntity<>(favouriteService.getALlFavourite(userMailId), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("try after some time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
