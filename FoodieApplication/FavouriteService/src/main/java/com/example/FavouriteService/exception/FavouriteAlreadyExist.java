package com.example.FavouriteService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "Already Exist")
public class FavouriteAlreadyExist extends Exception{
}
