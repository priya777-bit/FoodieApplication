//package com.example.FavouriteService;
//
//import com.example.FavouriteService.model.Favourite;
//import com.example.FavouriteService.repository.FavouriteRepository;
//import com.example.FavouriteService.service.FavouriteServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class FavouriteServiceLayerTest {
//
//    @InjectMocks
//    private FavouriteServiceImpl favouriteService;
//
//    @Mock
//    private FavouriteRepository favouriteRepository;
//
//    private Favourite favourite,favourite1;
//
//    private List<Favourite> favouriteList;
//
//    @BeforeEach
//    public void setUp()
//    {
//        favourite = new Favourite("f001","priya@gmail.com","curry leaves","naan");
//        favourite1 = new Favourite("f002","priya@gmail.com","orange tree","biryani");
//        favouriteList = Arrays.asList(favourite,favourite1);
//    }
//
//    @BeforeEach
//    public void tearDown()
//    {
//        favourite=favourite1=null;
//        favouriteList=null;
//    }
//
//    @Test
//    public void givenFavouriteToAddReturnFavourite()
//    {
//        when(favouriteRepository.existsById(favourite.getFavouriteId())).thenReturn(false);
//        when(favouriteRepository.save(favourite)).thenReturn(favourite);
//        assertEquals(favourite,favouriteService.addFavourite(favourite));
//        verify(favouriteRepository,times(1)).existsById(favourite.getFavouriteId());
//        verify(favouriteRepository,times(1)).save(favourite);
//    }
//
//    @Test
//    public void givenUserMailIdReturnFavouriteList()
//    {
//        when(favouriteRepository.findByUserMailId(favourite.getUserMailId())).thenReturn(favouriteList);
//        assertEquals(favouriteList,favouriteService.getALlFavourite(favourite.getUserMailId()));
//        verify(favouriteRepository,times(1)).findByUserMailId(favourite.getUserMailId());
//    }
//}
