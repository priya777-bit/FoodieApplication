package com.example.OrderService;

import com.example.OrderService.controller.OrderController;
import com.example.OrderService.exception.OrderAlreadyExistsException;
import com.example.OrderService.model.Food;
import com.example.OrderService.model.Order;
import com.example.OrderService.model.Restaurant;
import com.example.OrderService.service.OrderServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
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
public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderServiceImpl orderService;

    private Order order,order1;

    private Food food,food1;

    private Restaurant restaurant;

    private List<Food> foodList;

    private List<Order> orderList;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp()
    {
        food = new Food("d1","dokla","veg");
        food1 = new Food("d2","fafda","veg");
        foodList = Arrays.asList(food,food1);

        restaurant = new Restaurant("r001","cuisnes","delhi");

        order = new Order("o1","priya@gmail.com",restaurant,foodList,400);
        order1 = new Order("o2","priya@gmail.com",restaurant,foodList,300);

        orderList = Arrays.asList(order,order1);

        mockMvc = MockMvcBuilders.standaloneSetup(OrderController.class).build();
    }

    @AfterEach
    public void tearDown()
    {
        food = food1 = null;
        restaurant = null;
        order = order1 = null;
    }

    @Test
    public void addToCartSuccess() throws Exception {
        when(orderService.saveOrder(order)).thenReturn(order);

        mockMvc.perform(post("/api/user/users/order/addToCart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(order)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());

        verify(orderService,times(1)).saveOrder(order);
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
