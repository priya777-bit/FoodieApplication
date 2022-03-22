package com.example.FavouriteService;

import com.example.FavouriteService.model.Favourite;
import com.example.FavouriteService.repository.FavouriteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class FavouriteRepositoryTest {

    @Autowired
    private FavouriteRepository favouriteRepository;

    private Favourite favourite,favourite1;

    private List<Favourite> favouriteList;

    @BeforeEach
    public void setUp()
    {
        favourite = new Favourite("f001","priya@gmail.com","curry leaves","naan");
        favourite1 = new Favourite("f002","priya@gmail.com","orange tree","biryani");
        favouriteList = Arrays.asList(favourite,favourite1);
    }

    @AfterEach
    public void tearDown()
    {
        favourite=null;
        favouriteRepository.deleteAll();
    }

    @Test
    public void givenFavouriteToAddReturnFavourite()
    {
        favouriteRepository.insert(favourite);
        Favourite favourite1 = favouriteRepository.findById(favourite.getFavouriteId()).get();
        assertNotNull(favourite1);
        assertEquals(favourite,favourite1);
    }

    @Test
    public void givenUserMailIdReturnFavouriteList()
    {
        favouriteRepository.insert(favourite);
        favouriteRepository.insert(favourite1);
        List<Favourite> favouriteList1 = favouriteRepository.findByUserMailId(favourite.getUserMailId());
        assertNotNull(favouriteList1);
        assertEquals(favouriteList,favouriteList1);
    }
}
