//package com.example.searchService;
//
//import com.example.searchService.model.Dish;
//import com.example.searchService.model.Restaurant;
//import com.example.searchService.repository.SearchRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import static org.junit.jupiter.api.Assertions.*;
//
//
//import java.util.Arrays;
//import java.util.List;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class SearchRepositoryTest
//{
//    @Autowired
//    private SearchRepository searchRepository;
//
//    private Restaurant restaurant;
//    private Dish dish,dish1;
//    private List<Dish> dishList;
//
//    @BeforeEach
//    private void setUp()
//    {
//        dish=new Dish("d001","fried","veg");
//        dish1=new Dish("d002","Chicken fried rice","Non veg");
//        dishList= Arrays.asList(dish,dish1);
//        restaurant=new Restaurant("r001","a2b","chennai",dishList);
//    }
//
//    @AfterEach
//    private void tearDown()
//    {
//        dish=null;
//        dish1=null;
//        restaurant=null;
//        searchRepository.deleteAll();
//    }
//
//    @Test
//    public void saveRestaurantSuccess()
//    {
//        searchRepository.insert(restaurant);
//        Restaurant restaurant1=searchRepository.findById(restaurant.getRestaurantId()).get();
//        assertEquals(restaurant1.getRestaurantId(),restaurant.getRestaurantId());
//    }
//
//    @Test
//    public void saveRestaurantFailure()
//    {
//        searchRepository.insert(restaurant);
//        Restaurant restaurant1=searchRepository.findById(restaurant.getRestaurantId()).get();
//        assertNotEquals(restaurant1.getRestaurantId(),"r002");
//    }
//
//    @Test
//    public void saveDishSuccess()
//    {
//        Restaurant restaurant1=new Restaurant("r001","a2b","chennai",null);
//        searchRepository.insert(restaurant1);
//        Restaurant restaurant2=searchRepository.findById(restaurant1.getRestaurantId()).get();
//        assertEquals(restaurant1,restaurant2);
//        restaurant1.setDishList(dishList);
//        assertEquals(2,restaurant1.getDishList().size());
//    }
//
//    @Test
//    public void saveDishFailure()
//    {
//        Restaurant restaurant1=new Restaurant("r001","a2b","chennai",null);
//        searchRepository.insert(restaurant1);
//        assertNotEquals(restaurant1,restaurant);
//        restaurant1.setDishList(dishList);
//        assertNotEquals(0,restaurant1.getDishList().size());
//    }
//
//    @Test
//    public void searchRestaurantSuccess()
//    {
//        searchRepository.insert(restaurant);
//        Restaurant restaurant1=searchRepository.findById(restaurant.getRestaurantId()).get();
//        assertEquals(Arrays.asList(restaurant),searchRepository.findByRestaurantName(restaurant1.getRestaurantName()));
//    }
//
//    @Test
//    public void searchRestaurantFailure()
//    {
//        searchRepository.insert(restaurant);
//        Restaurant restaurant1=searchRepository.findById(restaurant.getRestaurantId()).get();
//        assertNotEquals(restaurant,searchRepository.findByRestaurantName(restaurant1.getRestaurantName()));
//    }
//
//    @Test
//    public void searchDishSuccess()
//    {
//        searchRepository.insert(restaurant);
//        Restaurant restaurant1=searchRepository.findById(restaurant.getRestaurantId()).get();
//        assertEquals(dishList.get(0),searchRepository.findAllRestaurantFromDishName(restaurant.getDishList().get(0).getDishName()));
//    }
//}
