package com.example.OrderService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT , reason = "Order Already Exists ..")
public class OrderAlreadyExistsException extends Exception{
}
