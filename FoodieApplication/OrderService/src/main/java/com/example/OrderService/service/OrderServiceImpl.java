package com.example.OrderService.service;

import com.example.OrderService.exception.OrderAlreadyExistsException;
import com.example.OrderService.exception.OrderNotFound;
import com.example.OrderService.model.Food;
import com.example.OrderService.model.Order;
import com.example.OrderService.model.Restaurant;
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
    public Order saveOrder(Order order) throws OrderAlreadyExistsException {
        if (orderRepository.findById(order.getOrderId()).isPresent())
        {
            throw new OrderAlreadyExistsException();
        }
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

    @Override
    public List<Food> addDishToOrder(String orderId, String restaurantId, Food dish) {
        Order order = orderRepository.findById(orderId).get();
        List<Restaurant> restaurantList = orderRepository.findById(orderId).get().getRestaurantList();
        List<Food> dishList=null;
        for(int i =0; i<restaurantList.size();i++) {
            Restaurant restaurant = restaurantList.get(i);
//            System.out.println(restaurant);
            String restId = restaurant.getRestaurantId();
            if(restId.equalsIgnoreCase(restaurantId)){
                dishList = restaurant.getDishList();
                dishList.add(dish);
                restaurantList.set(i,restaurant);
            }
            order.setRestaurantList(restaurantList);
            orderRepository.save(order);
        }
        return dishList;
    }
}
