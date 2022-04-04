package com.example.RestuarantManagementService.producerConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerMessageConfiguration {

    private String exchangeName="search_exchange";
    private String searchDishQueue="search_dish_queue";
    private String searchRestQueue="search_rest_queue";
    private String foodInvenDishQueue="inventory_dish_queue";
    private String foodInvenRestQueue="inventory_rest_queue";

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Queue searchRestQueue(){
        return  new Queue(searchRestQueue);
    }

    @Bean
    public Queue searchDishQueue(){
        return new Queue(searchDishQueue);
    }

    @Bean
    public Queue foodInvenDishQueue(){
        return  new Queue(foodInvenDishQueue);
    }

    @Bean
    public Queue foodInvenRestQueue(){
        return new Queue(foodInvenRestQueue);
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate= new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    Binding bindingRest(Queue searchRestQueue,DirectExchange directExchange){
        return BindingBuilder.bind(searchRestQueue()).to(directExchange).with("search_rest_routing");
    }

    @Bean
    Binding bindingDish(Queue searchDishQueue,DirectExchange directExchange){
        return BindingBuilder.bind(searchDishQueue()).to(directExchange).with("search_dish_routing");
    }

    @Bean
    Binding bindingInventoryRest(Queue foodInvenRestQueue,DirectExchange directExchange){
        return BindingBuilder.bind(foodInvenRestQueue()).to(directExchange).with("search_rest_routing");
    }

    @Bean
    Binding bindingInventoryDish(Queue foodInvenDishQueue,DirectExchange directExchange){
        return BindingBuilder.bind(foodInvenDishQueue()).to(directExchange).with("search_dish_routing");
    }

}
