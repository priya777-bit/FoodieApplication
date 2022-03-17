package com.example.OrderService.service;

import com.example.OrderService.exception.OrderNotFound;
import com.example.OrderService.model.Order;
import com.example.OrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrderOfUser(String userMailId) throws OrderNotFound {
        if(orderRepository.findByUserMailId(userMailId).isEmpty())
        {
            throw new OrderNotFound();
        }
        else
        {
            return orderRepository.findByUserMailId(userMailId);
        }
    }

    @Override
    public List<Order> getAllOrderOfUser() {
        return orderRepository.findAll();
    }
}
