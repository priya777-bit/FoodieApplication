package com.example.OrderService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "No Orders Found")
public class OrderNotFound extends Exception{
}
