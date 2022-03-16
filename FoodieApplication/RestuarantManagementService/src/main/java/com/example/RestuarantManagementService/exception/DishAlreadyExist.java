package com.example.RestuarantManagementService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Dish Already Exist")
public class DishAlreadyExist extends Exception{
}
