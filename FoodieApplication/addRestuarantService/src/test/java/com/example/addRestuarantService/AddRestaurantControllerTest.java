//package com.example.addRestuarantService;
//
//import com.example.addRestuarantService.config.Producer;
//import com.example.addRestuarantService.controller.RestaurantController;
//import com.example.addRestuarantService.model.Dish;
//import com.example.addRestuarantService.model.Restaurant;
//import com.example.addRestuarantService.rabbitmq.RestaurantDTO;
//import com.example.addRestuarantService.service.RestaurantServiceImpl;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class AddRestaurantControllerTest {
//
//    @InjectMocks
//    private RestaurantController restaurantController;
//
//    @Mock
//    private RestaurantServiceImpl restaurantService;
//
//    private Restaurant restaurant;
//
//    private Dish dish,dish1;
//
//    private List<Dish> dishList;
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    Producer producer;
//
//    @BeforeEach
//    public void setUp()
//    {
//        dish = new Dish("d1","kofta","veg");
//        dish1 = new Dish("d2","paneer","veg");
//        dishList = Arrays.asList(dish,dish1);
//        restaurant = new Restaurant("r001","leaves","nasik",dishList);
//        mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
//    }
//
//    @AfterEach
//    public void tearDown()
//    {
//        dish=dish1=null;
//        restaurant=null;
//    }
//
//    @Test
//    public void addRestaurant() throws Exception {
////        RestaurantDTO restaurantDTO = new RestaurantDTO();
////        restaurantDTO.setRestaurantId(restaurant.getRestaurantId());
////        restaurantDTO.setRestaurantName(restaurant.getRestaurantName());
////        restaurantDTO.setRestaurantLocation(restaurant.getRestaurantLocation());
//
//        when(restaurantService.addRestaurant(restaurant)).thenReturn(restaurant);
//
//        mockMvc.perform(post("/api/request/restaurant")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonToString(restaurant)))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//
//        verify(restaurantService,times(1)).addRestaurant(restaurant);
////        verify(producer,times(1)).sendRestMsg2RabbitMq(restaurantDTO);
//
//    }
//
//    @Test
//    public void addDish() throws Exception {
//        when(restaurantService.addDish(any(),any())).thenReturn(restaurant);
//
//        mockMvc.perform(put("/api/request/r001/dish")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonToString(dish)))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//
//        verify(restaurantService,times(1)).addDish(any(),any());
//    }
//
//    private static String jsonToString(final Object object) throws JsonProcessingException
//    {
//        String text = null;
//        try
//        {
//            ObjectMapper objectMapper = new ObjectMapper();
//            String jsonText=objectMapper.writeValueAsString(object);
//            text = jsonText;
//        }
//        catch (JsonProcessingException je)
//        {
//            text = "Caught Error During Conversion Of Format";
//        }
//        return text;
//
//    }
//}
