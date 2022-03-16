package com.example.UserAuthenticationService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "User Already Exist")
public class UserAlreadyExist extends Exception{
}
