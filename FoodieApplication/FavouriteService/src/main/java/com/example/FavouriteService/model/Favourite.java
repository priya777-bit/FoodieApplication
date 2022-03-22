package com.example.FavouriteService.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favourite {

    @Id
    private String favouriteId;
    private String userMailId;
    private String restaurantName;
    private String foodName;

}
