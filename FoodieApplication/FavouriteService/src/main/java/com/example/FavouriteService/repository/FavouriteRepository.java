package com.example.FavouriteService.repository;

import com.example.FavouriteService.model.Favourite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends MongoRepository<Favourite,String> {

    List<Favourite> findByUserMailId(String userMailId);
}
