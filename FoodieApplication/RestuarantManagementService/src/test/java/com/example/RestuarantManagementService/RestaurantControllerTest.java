//package com.example.RestuarantManagementService;
//
//import com.example.RestuarantManagementService.controller.RestaurantController;
//import com.example.RestuarantManagementService.model.Dish;
//import com.example.RestuarantManagementService.model.Restaurant;
//import com.example.RestuarantManagementService.service.RestaurantServiceImpl;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class RestaurantControllerTest {
//
//    @Mock
//    private RestaurantServiceImpl restaurantService;
//
//    @InjectMocks
//    private RestaurantController restaurantController;
//
////    @Autowired
////    private RabbitListener rabbitListener;
//
//    private Restaurant restaurant;
//    private Dish dish1;
//    private Dish dish2;
//    private List<Dish> dishList;
//    private List<Restaurant> restaurantList;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void setUp(){
//        dish1 = new Dish("d1","babycorn","veg");
//        dish2 = new Dish("d2","springroll","veg");
//        dishList = Arrays.asList(dish1,dish2);
//        restaurant = new Restaurant("rest1","priyElite","Nasik",dishList);
//        restaurantList = Arrays.asList(restaurant);
//        mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
//    }
//
//    @AfterEach
//    public void tearDown(){
//        dish1 = dish2 = null;
//        restaurant = null;
//    }
//
//    @Test
//    public void registerRestaurantSuccess() throws Exception {
//        when(restaurantService.registerRestaurant(any())).thenReturn(restaurant);
//        mockMvc.perform(post("/api/user/admin/restaurant/save")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(convertJsonToString(restaurant))).andExpect(status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//
//        verify(restaurantService,times(1)).registerRestaurant(any());
//    }
//
//    private static String convertJsonToString(final Object object) throws JsonProcessingException{
//        String result = null;
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            String jsonContent = objectMapper.writeValueAsString(object);
//            result = jsonContent;
//        }
//        catch (JsonProcessingException e){
//            result = "Error While Processing";
//        }
//        return result;
//    }
//
//    @Test
//    public void removeRestaurantSuccess() throws Exception{
//        when(restaurantService.removeRestaurant(anyString())).thenReturn(true);
//        mockMvc.perform(delete("/api/user/admin/restaurant/rest1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//        verify(restaurantService,times(1)).removeRestaurant(anyString());
//
//    }
//
//    @Test
//    public void addDishToRestaurant() throws Exception{
//        when(restaurantService.addDishToRestaurant(anyString(),any())).thenReturn(restaurant);
//        mockMvc.perform(put("/api/user/admin/restaurant/rest1/dish")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(convertJsonToString(dish1))).andExpect(status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//        verify(restaurantService,times(1)).addDishToRestaurant(anyString(),any());
//    }
//
//    @Test
//    public void removeDishFromRestaurantSuccess() throws Exception{
//        when(restaurantService.removeDishFromRestaurant(anyString(),anyString())).thenReturn(restaurant);
//        mockMvc.perform(delete("/api/user/admin/restaurant/rest1/dish/d1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//        verify(restaurantService,times(1)).removeDishFromRestaurant(anyString(),anyString());
//    }
//
//    @Test
//    public void findAllRestaurant() throws Exception{
//        when(restaurantService.findAllRestaurant()).thenReturn(restaurantList);
//        mockMvc.perform(get("/api/user/admin/restaurant/find")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(convertJsonToString(restaurantList))).andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//        verify(restaurantService,times(1)).findAllRestaurant();
//    }
//}
