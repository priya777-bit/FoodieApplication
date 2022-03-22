package com.example.searchService;

import com.example.searchService.model.Dish;
import com.example.searchService.model.Restaurant;
import com.example.searchService.repository.SearchRepository;
import com.example.searchService.service.SearchServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    private SearchRepository searchRepository;

    @InjectMocks
    private SearchServiceImpl searchService;

    private Restaurant restaurant;
    private Dish dish,dish1;
    private List<Dish> dishList;

    @BeforeEach
    private void setUp()
    {
        dish=new Dish("d001","fried","veg");
        dish1=new Dish("d002","Chicken fried rice","Non veg");
        dishList= Arrays.asList(dish,dish1);
        restaurant=new Restaurant("r001","a2b","chennai",dishList);
    }

    @AfterEach
    private void tearDown()
    {
        dish=null;
        dish1=null;
        restaurant=null;
    }

    @Test
    public void saveRestaurantSuccess()
    {
        when(searchRepository.save(restaurant)).thenReturn(restaurant);
        assertEquals(restaurant,searchService.saveRestaurant(restaurant));
        verify(searchRepository,times(1)).save(restaurant);
    }

//    @Test
//    public void saveRestaurantFailure()
//    {
//        assertThrows(Exception.class,()->searchService.saveRestaurant(restaurant));
//        verify(searchRepository,times(0)).save(restaurant);
//    }
@Test
public void saveDishSuccess()
{
    Restaurant restaurant1=new Restaurant("r001","a2b","chennai",null);
    when(searchRepository.findById(restaurant1.getRestaurantId())).thenReturn(Optional.ofNullable(restaurant1));
    List<Dish> dishList=restaurant1.getDishList();
    when(dishList==null).thenReturn(false);
    restaurant1.setDishList(dishList);
    when(searchRepository.save(restaurant1)).thenReturn(restaurant1);
    assertEquals(dish,searchService.saveDish(restaurant1.getRestaurantId(),dish));
    verify(searchRepository,times(1)).findById(restaurant.getRestaurantId());
    verify(searchRepository,times(1)).findById(restaurant.getRestaurantId());
}
}
