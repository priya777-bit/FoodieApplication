package com.example.FavouriteService.model;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Favourite {

    @Id
    private String favouriteId;
    private String userMailId;
    private String restaurantName;
    private String foodName;

}
