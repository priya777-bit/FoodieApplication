package com.example.RestuarantManagementService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "No Data Found")
public class RestaurantNotFound extends Exception{
}
