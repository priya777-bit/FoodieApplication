package com.example.OrderService.service;

import com.example.OrderService.exception.OrderAlreadyExistsException;
import com.example.OrderService.exception.OrderNotFound;
import com.example.OrderService.model.Food;
import com.example.OrderService.model.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order) throws OrderAlreadyExistsException;
    List<Order> getOrderOfUser(String userMailId) throws OrderNotFound;
    List<Order> getAllOrderOfUser();
    List<Food> addDishToOrder(String orderId, String restaurantId, Food dish);
    boolean removeFromOrder(String orderId);
}
