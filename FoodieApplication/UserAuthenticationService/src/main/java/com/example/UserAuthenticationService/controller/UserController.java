package com.example.UserAuthenticationService.controller;

import com.example.UserAuthenticationService.exception.UserAlreadyExist;
import com.example.UserAuthenticationService.exception.UserNotFound;
import com.example.UserAuthenticationService.model.User;
import com.example.UserAuthenticationService.service.SecurityTokenGenerator;
import com.example.UserAuthenticationService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/userAuthentication")
public class UserController {

    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService,SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator=securityTokenGenerator;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExist {
        try{
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
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

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws UserNotFound {
        try{
            Map<String,String> map=null;
            User getUser=userService.findByUserMailIdAndUserPassword(user.getUserMailId(), user.getUserPassword());
            if(getUser.getUserMailId().equalsIgnoreCase(user.getUserMailId()))
            {
                map=securityTokenGenerator.generateToken(user);
            }
            return new ResponseEntity(map,HttpStatus.OK);
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

    @GetMapping("/getData")
    public ResponseEntity<?> getUser() throws UserNotFound {
        try{
            return new ResponseEntity<>(userService.GetAllData(), HttpStatus.OK);
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
