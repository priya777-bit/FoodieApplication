package com.example.UserAuthenticationService.service;

import com.example.UserAuthenticationService.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}
