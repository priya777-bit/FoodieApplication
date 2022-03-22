package com.example.RestuarantManagementService.producerConfig;

import com.example.RestuarantManagementService.rabbitMq.DishDTO;
import com.example.RestuarantManagementService.rabbitMq.RestaurantDTO;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private RabbitTemplate rabbitTemplate;
    private DirectExchange directExchange;


    @Autowired
    public Producer(RabbitTemplate rabbitTemplate,DirectExchange directExchange){
        super();
        this.rabbitTemplate=rabbitTemplate;
        this.directExchange=directExchange;
    }

    public void sendMessageToRabbitMQ(DishDTO dishDTO){
        rabbitTemplate.convertAndSend(directExchange.getName(),"search_dish_routing",dishDTO);
    }

    public void sendMessageToRabbit(RestaurantDTO restaurantDTO){
        rabbitTemplate.convertAndSend(directExchange.getName(),"search_rest_routing",restaurantDTO);
    }
}
