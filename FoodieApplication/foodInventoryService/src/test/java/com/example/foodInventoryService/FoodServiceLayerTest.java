package com.example.foodInventoryService;

import com.example.foodInventoryService.model.Dish;
import com.example.foodInventoryService.model.Restaurant;
import com.example.foodInventoryService.repository.FoodRepository;
import com.example.foodInventoryService.service.FoodServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FoodServiceLayerTest {

    @InjectMocks
    private FoodServiceImpl foodService;

    @Mock
    private FoodRepository foodRepository;

    private Restaurant restaurant;

    private Dish dish,dish1;

    private List<Dish> dishList;

    @BeforeEach
    public void setUp()
    {
        dish = new Dish("d1","faluda","veg");
        dish1 = new Dish("d2","lassi","drink");
        dishList = Arrays.asList(dish,dish1);
        restaurant = new Restaurant("r001","patel","ahmedabad",dishList);
    }

    @AfterEach
    public void tearDown()
    {
        dish=dish1=null;
        restaurant=null;
        dishList=null;
    }

    @Test
    public void givenRestaurantToSaveReturnRestaurant()
    {
        when(foodRepository.save(restaurant)).thenReturn(restaurant);
        assertEquals(restaurant,foodService.saveRestaurant(restaurant));
        verify(foodRepository,times(1)).save(restaurant);
    }

    @Test
    public void givenDishAddInDishListAndReturnDishList()
    {
        when(foodRepository.findById(restaurant.getRestaurantId())).thenReturn(Optional.ofNullable(restaurant));
        Dish dish2 = new Dish("d3","mix","non veg");
        List<Dish> dishList1 = foodService.saveDish(restaurant.getRestaurantId(),dish2);
        assertEquals(restaurant.getDishList(),dishList1);
        verify(foodRepository,times(1)).findById(restaurant.getRestaurantId());
        verify(foodRepository,times(1)).save(restaurant);
    }
}
