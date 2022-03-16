package com.example.addRestuarantService.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MessageConfiguration {

    private String exchangeName = "rest_exchange";

    private String register_rest_queue = "rest_queue";

    private String register_dish_queue = "dish_queue";

    @Bean
    public DirectExchange directExchange()
    {
        return new DirectExchange(exchangeName);
    }

    @Bean
    @Primary
    public Queue registerRestaurantQueue()
    {
        return new Queue(register_rest_queue);
    }

    @Bean
    public Queue registerDishQueue()
    {
        return new Queue(register_dish_queue);
    }

    @Bean
    Jackson2JsonMessageConverter jackson2JsonMessageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Binding bindingRestaurant(Queue register_rest_queue, DirectExchange exchangeName)
    {
        return BindingBuilder.bind(registerRestaurantQueue()).to(exchangeName).with("rest_routing");
    }

    @Bean
    public Binding bindingDish(Queue register_dish_queue, DirectExchange exchangeName)
    {
        return BindingBuilder.bind(registerDishQueue()).to(exchangeName).with("dish_routing");
    }
}
