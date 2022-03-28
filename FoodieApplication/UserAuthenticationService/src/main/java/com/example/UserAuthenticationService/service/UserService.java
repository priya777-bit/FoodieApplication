package com.example.UserAuthenticationService.service;

import com.example.UserAuthenticationService.exception.UserAlreadyExist;
import com.example.UserAuthenticationService.exception.UserNotFound;
import com.example.UserAuthenticationService.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user) throws UserAlreadyExist;
    User findByUserMailIdAndUserPassword(String userMailId,String userPassword) throws UserNotFound;
    List<User> GetAllData() throws UserNotFound;

}
