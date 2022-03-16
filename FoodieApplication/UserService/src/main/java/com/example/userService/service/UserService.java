package com.example.userService.service;

import com.example.userService.exception.UserAlreadyExist;
import com.example.userService.exception.UserNotFound;
import com.example.userService.model.User;

import java.util.List;

public interface UserService {

    User registerUser(User user) throws UserAlreadyExist;
    User getUserData(String userEmail)throws UserNotFound;
    List<User>  getAllUserData()throws UserNotFound;

}
