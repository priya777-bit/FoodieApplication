package com.example.foodInventoryService;

import com.example.foodInventoryService.controller.FoodController;
import com.example.foodInventoryService.model.Dish;
import com.example.foodInventoryService.model.Restaurant;
import com.example.foodInventoryService.service.FoodServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class FoodControllerTest {

    @InjectMocks
    private FoodController foodController;

    @Mock
    private FoodServiceImpl foodService;

    private Restaurant restaurant;

    private Dish dish,dish1;

    private List<Dish> dishList;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp()
    {
        dish = new Dish("d1","faluda","veg");
        dish1 = new Dish("d2","lassi","drink");
        dishList = Arrays.asList(dish,dish1);
        restaurant = new Restaurant("r001","patel","ahmedabad",dishList);

        mockMvc = MockMvcBuilders.standaloneSetup(FoodController.class).build();
    }

    @AfterEach
    public void tearDown()
    {
        dish=dish1=null;
        restaurant=null;
    }

    @Test
    public void saveRestaurant() throws Exception {
        when(foodService.saveRestaurant(any())).thenReturn(restaurant);

        mockMvc.perform(post("/api/inventory/restaurant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(restaurant)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());

        verify(foodService,times(1)).saveRestaurant(any());
    }

    @Test
    public void saveDish() throws Exception {
        when(foodService.saveDish(any(),any())).thenReturn(dishList);

        mockMvc.perform(post("/api/inventory/r001")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(dish)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());

        verify(foodService,times(1)).saveDish(any(),any());
    }

    private static String jsonToString(final Object object) throws JsonProcessingException
    {
        String text = null;
        try
        {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonText=objectMapper.writeValueAsString(object);
            text = jsonText;
        }
        catch (JsonProcessingException je)
        {
            text = "Caught Error During Conversion Of Format";
        }
        return text;

    }
}
