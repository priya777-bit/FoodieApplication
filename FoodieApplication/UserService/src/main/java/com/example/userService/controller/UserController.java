package com.example.userService.controller;

import com.example.userService.exception.UserAlreadyExist;
import com.example.userService.exception.UserNotFound;
import com.example.userService.model.User;
import com.example.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExist {
        try {
            return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
        }
        catch (UserAlreadyExist error)
        {
            throw new UserAlreadyExist();
        }
        catch (Exception error)
        {
            return new ResponseEntity<>("try after some time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUserProfile/{userEmail}")
    public ResponseEntity<?> getUserProfile(@PathVariable String userEmail) throws UserNotFound {
        try {
            return new ResponseEntity<>(userService.getUserData(userEmail), HttpStatus.OK);
        }
        catch (UserNotFound error)
        {
            throw new UserNotFound();
        }
        catch (Exception error)
        {
            return new ResponseEntity<>("try after some time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllUserProfile")
    public ResponseEntity<?> getAllUserProfile() throws UserNotFound {
        try {
            return new ResponseEntity<>(userService.getAllUserData(), HttpStatus.OK);
        }
        catch (UserNotFound error)
        {
            throw new UserNotFound();
        }
        catch (Exception error)
        {
            return new ResponseEntity<>("try after some time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
