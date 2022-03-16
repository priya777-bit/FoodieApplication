package com.example.addRestuarantService.config;

import com.example.addRestuarantService.rabbitmq.DishDTO;
import com.example.addRestuarantService.rabbitmq.RestaurantDTO;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange exchangeName;

    public void sendRestMsg2RabbitMq(RestaurantDTO restaurantDTO)
    {
        rabbitTemplate.convertAndSend(exchangeName.getName(),"rest_routing",restaurantDTO);
    }

    public void sendDishMsg2RabbitMq(DishDTO dishDTO)
    {
        rabbitTemplate.convertAndSend(exchangeName.getName(),"dish_routing",dishDTO);
    }
}
