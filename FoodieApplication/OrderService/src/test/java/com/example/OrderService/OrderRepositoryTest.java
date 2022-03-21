package com.example.OrderService;

import com.example.OrderService.model.Food;
import com.example.OrderService.model.Order;
import com.example.OrderService.model.Restaurant;
import com.example.OrderService.repository.OrderRepository;
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
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    private Order order,order1;

    private Food food,food1;

    private Restaurant restaurant;

    private List<Food> foodList;

    private List<Order> orderList;

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
    }

    @AfterEach
    public void tearDown()
    {
        food=food1=null;
        restaurant=null;
        order=order1=null;
        orderRepository.deleteAll();
    }

    @Test
    public void givenOrderToSaveReturnOrder()
    {
        orderRepository.insert(order);
        Order order1 = orderRepository.findById(order.getOrderId()).get();
        assertNotNull(order1);
        assertEquals(order.getOrderId(),order1.getOrderId());
    }

    @Test
    public void givenUserMailIdReturnOrderList()
    {
        orderRepository.insert(order);
        orderRepository.insert(order1);
        String userMailId = "priya@gmail.com";
        List<Order> orderList1 = orderRepository.findByUserMailId(userMailId);
        assertNotNull(orderList1);
        assertEquals(orderList,orderList1);
    }

    @Test
    public void returnAllOrderOfUser()
    {
        orderRepository.insert(order);
        orderRepository.insert(order1);
        List<Order> orderList1 = orderRepository.findAll();
        assertNotNull(orderList1);
        assertEquals(orderList,orderList1);
    }
}
