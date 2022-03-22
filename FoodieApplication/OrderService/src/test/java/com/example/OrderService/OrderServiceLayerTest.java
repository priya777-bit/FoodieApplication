package com.example.OrderService;

import com.example.OrderService.exception.OrderAlreadyExistsException;
import com.example.OrderService.exception.OrderNotFound;
import com.example.OrderService.model.Food;
import com.example.OrderService.model.Order;
import com.example.OrderService.model.Restaurant;
import com.example.OrderService.repository.OrderRepository;
import com.example.OrderService.service.OrderServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceLayerTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
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
    public void tearDown() {
        food = food1 = null;
        restaurant = null;
        order = order1 = null;
        foodList=null;
        orderList=null;
    }

    @Test
    public void givenOrderToSaveReturnOrderSuccess() throws OrderAlreadyExistsException
    {
        when(orderRepository.findById(order.getOrderId())).thenReturn(Optional.ofNullable(null));
        when(orderRepository.save(order)).thenReturn(order);
        assertEquals(order,orderService.saveOrder(order));
        verify(orderRepository,times(1)).findById(order.getOrderId());
        verify(orderRepository,times(1)).save(order);
    }

    @Test
    public void givenOrderToSaveReturnOrderFail() throws OrderAlreadyExistsException
    {
        when(orderRepository.findById(order.getOrderId())).thenReturn(Optional.ofNullable(order));
        assertThrows(OrderAlreadyExistsException.class,()->orderService.saveOrder(order));
        verify(orderRepository,times(1)).findById(order.getOrderId());
        verify(orderRepository,times(0)).save(order);
    }

    @Test
    public void givenUserMailIdReturnOrderListSuccess() throws OrderNotFound {
        when(orderRepository.findByUserMailId(order.getUserMailId())).thenReturn(orderList);
        assertEquals(orderList,orderService.getOrderOfUser(order.getUserMailId()));
        verify(orderRepository,times(2)).findByUserMailId(order.getUserMailId());
    }

    @Test
    public void givenUserMailIdReturnOrderListFail()
    {
        List<Order> orderList1 = new ArrayList<>();
        when(orderRepository.findByUserMailId(order.getUserMailId())).thenReturn(orderList1);
        assertThrows(OrderNotFound.class,()->orderService.getOrderOfUser(order.getUserMailId()));
        verify(orderRepository,times(1)).findByUserMailId(order.getUserMailId());
    }

    @Test
    public void returnAllOrderOfUser()
    {
        when(orderRepository.findAll()).thenReturn(orderList);
        assertEquals(orderList,orderService.getAllOrderOfUser());
        verify(orderRepository,times(1)).findAll();
    }
}
