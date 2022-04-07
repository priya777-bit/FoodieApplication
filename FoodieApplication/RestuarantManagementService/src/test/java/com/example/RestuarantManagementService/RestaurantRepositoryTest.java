//package com.example.RestuarantManagementService;
//
//
//import com.example.RestuarantManagementService.model.Dish;
//import com.example.RestuarantManagementService.model.Restaurant;
//import com.example.RestuarantManagementService.repository.RestaurantRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class RestaurantRepositoryTest {
//
//    @Autowired
//    private RestaurantRepository restaurantRepository;
//
//    private Restaurant restaurant;
//    private Dish dish1;
//    private Dish dish2;
//    private List<Dish> dishList;
//    private List<Restaurant> restaurantList;
//
//
//    @BeforeEach
//    public void setUp(){
//        dish1 = new Dish("d1","babycorn","veg");
//        dish2 = new Dish("d2","springroll","veg");
//        dishList = Arrays.asList(dish1,dish2);
//        restaurant = new Restaurant("rest1","priyElite","Nasik",dishList);
//        restaurantList = Arrays.asList(restaurant);
//    }
//
//    @AfterEach
//    public void tearDown(){
//        dish1 = dish2 = null;
//        restaurant = null;
//        restaurantRepository.deleteAll();
//    }
//
//    @Test
//    public void registerRestaurantSuccess(){
//        restaurantRepository.insert(restaurant);
//        Restaurant expectedRestaurant = restaurantRepository.findById(restaurant.getRestaurantId()).get();
//        assertNotNull(expectedRestaurant);
//        assertEquals(restaurant.getRestaurantId(),expectedRestaurant.getRestaurantId());
//    }
//
//    @Test
//    public void removeRestaurantSuccess(){
//        restaurantRepository.insert(restaurant);
//        Restaurant expectedRestaurant = restaurantRepository.findById(restaurant.getRestaurantId()).get();
//        restaurantRepository.delete(expectedRestaurant);
//        assertEquals(Optional.empty(),restaurantRepository.findById(restaurant.getRestaurantId()));
//    }
//
//    @Test
//    public void addDishToRestaurantSuccess(){
//        restaurantRepository.insert(restaurant);
//        Restaurant expectedRestaurant = restaurantRepository.findById(restaurant.getRestaurantId()).get();
//        String dishId = "d1";
//        List<Dish> dishList = restaurant.getDishList();
//        assertNotNull(expectedRestaurant);
//        assertEquals(dishList.get(0).getDishId(),dishId);
//    }
//
//    @Test
//    public void removeDishFromRestaurantSuccess(){
//        restaurantRepository.insert(restaurant);
//        Restaurant restaurant1 = restaurantRepository.findById(restaurant.getRestaurantId()).get();
//        String dishId = "d1";
//        List<Dish> dishList1 = restaurant.getDishList();
//        Optional<Dish> isPresent = dishList1.stream().filter(dish -> dish.getDishId().equalsIgnoreCase(dishId)).findFirst();
//        List<Dish> dishList = dishList1.stream().filter(dish -> dish.getDishId().equalsIgnoreCase(dishId)).collect(Collectors.toList());
//        boolean result = dishList.remove(dishList.get(0));
//        assertEquals(true,result);
//    }
//
//    @Test
//    public void findAllRestaurantSuccess(){
//        List<Restaurant> restaurantList1 = restaurantRepository.findAll();
//    }
//}
