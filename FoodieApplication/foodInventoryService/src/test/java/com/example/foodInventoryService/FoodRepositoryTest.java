package com.example.foodInventoryService;

import com.example.foodInventoryService.model.Dish;
import com.example.foodInventoryService.model.Restaurant;
import com.example.foodInventoryService.repository.FoodRepository;
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
public class FoodRepositoryTest {

    @Autowired
    private FoodRepository foodRepository;

    private Restaurant restaurant;

    private Dish dish,dish1;

    private List<Dish> dishList;

    @BeforeEach
    public void setUp()
    {
        dish = new Dish("d1","dosa","veg");
        dish1 = new Dish("d2","biryani","non veg");
        dishList = Arrays.asList(dish,dish1);
        restaurant = new Restaurant("r001","multi cuisine","gujrat",dishList);
    }

    @AfterEach
    public void tearDown()
    {
        dish=dish1=null;
        restaurant=null;
        foodRepository.deleteAll();
    }

    @Test
    public void givenRestaurantToSaveReturnRestaurant()
    {
        foodRepository.insert(restaurant);
        Restaurant restaurant1 = foodRepository.findById(restaurant.getRestaurantId()).get();
        assertNotNull(restaurant1);
        assertEquals(restaurant.getRestaurantId(),restaurant1.getRestaurantId());
    }

    @Test
    public void givenDishAddInDishListAndReturnDishList()
    {
        Dish dish2 = new Dish("d3","salad","veg");
        dishList = Arrays.asList(dish2);
        restaurant.setDishList(dishList);
        assertEquals(restaurant.getDishList().size(),1);
    }
}
