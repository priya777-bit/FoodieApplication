//package com.example.RestuarantManagementService;
//
//import com.example.RestuarantManagementService.exception.DishAlreadyExist;
//import com.example.RestuarantManagementService.exception.DishNotFound;
//import com.example.RestuarantManagementService.exception.RestaurantAlreadyExist;
//import com.example.RestuarantManagementService.exception.RestaurantNotFound;
//import com.example.RestuarantManagementService.model.Dish;
//import com.example.RestuarantManagementService.model.Restaurant;
//import com.example.RestuarantManagementService.producerConfig.Producer;
//import com.example.RestuarantManagementService.rabbitMq.DishDTO;
//import com.example.RestuarantManagementService.rabbitMq.RestaurantDTO;
//import com.example.RestuarantManagementService.repository.RestaurantRepository;
//import com.example.RestuarantManagementService.service.RestaurantServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import static org.mockito.Mockito.*;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class RestaurantServiceTest {
//
//    @InjectMocks
//    private RestaurantServiceImpl restaurantService;
//
//
//    @Mock
//    private RestaurantRepository restaurantRepository;
//    private Producer producer;
//
//    private Restaurant restaurant;
//    private Dish dish1;
//    private Dish dish2;
//    private List<Dish> dishList;
//    private List<Restaurant> restaurantList;
//    private RestaurantDTO restaurantDTO;
//    private DishDTO dishDTO;
//
//    @BeforeEach
//    public void setUp(){
//        dish1 = new Dish("d1","babycorn","veg");
//        dish2 = new Dish("d2","springroll","veg");
//        dishList = Arrays.asList(dish1,dish2);
//        restaurant = new Restaurant("rest1","priyElite","Nasik",dishList);
//        //restaurantDTO = new RestaurantDTO(restaurant.getRestaurantId(),restaurant.getRestaurantName(),restaurant.getRestaurantLocation());
//        restaurantList = Arrays.asList(restaurant);
//    }
//
//    @AfterEach
//    public void tearDown(){
//        dish1 = dish2 = null;
//        restaurant = null;
//    }
//
//    @Test
//    public void registerRestaurantSuccess() throws RestaurantAlreadyExist {
//        when(restaurantRepository.findById(restaurant.getRestaurantId())).thenReturn(Optional.ofNullable(null));
//        when(restaurantRepository.save(restaurant)).thenReturn(restaurant);
//        RestaurantDTO restaurantDTO1 = new RestaurantDTO();
//        restaurantDTO1.setRestaurantId(restaurant.getRestaurantId());
//        restaurantDTO1.setRestaurantName(restaurant.getRestaurantName());
//        restaurantDTO1.setRestaurantLocation(restaurant.getRestaurantLocation());
//        System.out.println(restaurantDTO1);
//        producer.sendMessageToRabbit(restaurantDTO1);
//        assertEquals(restaurant,restaurantService.registerRestaurant(restaurant));
//        verify(restaurantRepository,times(1)).findById(restaurant.getRestaurantId());
//        verify(producer,times(1)).sendMessageToRabbit(restaurantDTO1);
//        verify(restaurantRepository,times(1)).save(restaurant);
//    }
//
//    @Test
//    public void removeRestaurantSuccess() throws RestaurantNotFound {
//        when(restaurantRepository.findById(restaurant.getRestaurantId())).thenReturn(Optional.ofNullable(restaurant));
//        boolean flag = restaurantService.removeRestaurant(restaurant.getRestaurantId());
//        assertEquals(true,flag);
//        verify(restaurantRepository,times(2)).findById(restaurant.getRestaurantId());
//        verify(restaurantRepository,times(1)).delete(restaurant);
//    }
//
//    @Test
//    public void addDishToRestaurantSuccess() throws RestaurantNotFound, DishAlreadyExist {
//        when(restaurantRepository.findById(restaurant.getRestaurantId())).thenReturn(Optional.ofNullable(restaurant));
//        when(restaurantRepository.save(restaurant)).thenReturn(restaurant);
//        List<Dish> dishList = restaurant.getDishList();
//        Dish dish = new Dish("d3","noodles","veg");
////        if(dishList.get(0).getDishId().equalsIgnoreCase(dish1.getDishId()))
//        DishDTO dishDTO = new DishDTO();
//        dishDTO.setRestaurantId(restaurant.getRestaurantId());
//        dishDTO.setDishId(dish.getDishId());
//        dishDTO.setDishName(dish.getDishName());
//        dishDTO.setDishType(dish.getDishType());
//        producer.sendMessageToRabbitMQ(dishDTO);
////        dishList.add(dish1);
////        restaurant.setDishList(dishList);
//        assertEquals(restaurant,restaurantService.addDishToRestaurant(restaurant.getRestaurantId(),dish));
//        verify(restaurantRepository,times(2)).findById(restaurant.getRestaurantId());
//        verify(producer,times(1)).sendMessageToRabbitMQ(dishDTO);
//        verify(restaurantRepository,times(1)).save(restaurant);
//
//    }
//
//    @Test
//    public void removeDishFromRestaurantSuccess() throws DishNotFound, RestaurantNotFound {
//        when(restaurantRepository.findById(restaurant.getRestaurantId())).thenReturn(Optional.ofNullable(restaurant));
//        when(restaurantRepository.save(restaurant)).thenReturn(restaurant);
//        List<Dish> dishList1 = restaurant.getDishList();
//        //String dishId = dishList1.get(0).getDishId();
//        String dishId = "d1";
//        Optional<Dish> isPresentDishId = dishList1.stream().filter(dish -> dish.getDishId().equalsIgnoreCase(dishId)).findFirst();
//        List<Dish> dishList = dishList1.stream().filter(dish -> dish.getDishId().equalsIgnoreCase(dishId)).collect(Collectors.toList());
//        boolean result = dishList.remove(dishList.get(0));
////        System.out.println(result);
////        System.out.println(dishList1);
////        System.out.println(isPresentDishId);
////        restaurant.setDishList(dishList);
////        System.out.println(restaurant);
//        //assertEquals(restaurant,);
//        assertEquals(restaurant,restaurantService.removeDishFromRestaurant(restaurant.getRestaurantId(),dishList1.get(0).getDishId()));
//        verify(restaurantRepository,times(2)).findById(restaurant.getRestaurantId());
//        verify(restaurantRepository,times(1)).save(restaurant);
//    }
//
//    @Test
//    public void findAllRestaurant(){
//        when(restaurantRepository.findAll()).thenReturn(restaurantList);
//        assertEquals(restaurantList,restaurantService.findAllRestaurant());
//        verify(restaurantRepository,times(1)).findAll();
//    }
//}
