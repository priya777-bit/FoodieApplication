package com.example.OrderService.service;

import com.example.OrderService.exception.OrderNotFound;
import com.example.OrderService.model.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    List<Order> getOrderOfUser(String userMailId) throws OrderNotFound;
    List<Order> getAllOrderOfUser();
}
