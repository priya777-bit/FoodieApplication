package com.example.OrderService.controller;

import com.example.OrderService.model.Order;
import com.example.OrderService.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/users/order")
public class OrderController {

    public OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @HystrixCommand(fallbackMethod = "fallbackLogin")
    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1000")
    @PostMapping("/addToCart")
    public ResponseEntity<?> addToCart(@RequestBody Order order)
    {
        try{
            return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.CREATED);
        }
        catch (Exception error)
        {
            return new ResponseEntity<>("try after some time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fallbackLogin(@RequestBody Order order){
        String msg="login failed";
        return new ResponseEntity<>(msg,HttpStatus.GATEWAY_TIMEOUT);
    }


    @GetMapping("/getUserOrder/{userMailId}")
    public ResponseEntity<?> getUserOrder(@PathVariable String userMailId)
    {
        try{
            return new ResponseEntity<>(orderService.getOrderOfUser(userMailId), HttpStatus.OK);
        }
        catch (Exception error)
        {
            return new ResponseEntity<>("try after some time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUserOrder")
    public ResponseEntity<?> getAllOrder()
    {
        try{
            return new ResponseEntity<>(orderService.getAllOrderOfUser(), HttpStatus.OK);
        }
        catch (Exception error)
        {
            return new ResponseEntity<>("try after some time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
