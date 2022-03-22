package com.example.userService.service;

import com.example.userService.exception.UserAlreadyExist;
import com.example.userService.exception.UserNotFound;
import com.example.userService.model.User;
import com.example.userService.proxy.UserProxy;
import com.example.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserProxy userProxy;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,UserProxy userProxy)
    {
        this.userRepository=userRepository;
        this.userProxy=userProxy;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExist {
       if(userRepository.findById(user.getUserMailId()).isPresent())
       {
           throw new UserAlreadyExist();
       }
       else
       {
           userProxy.saveUser(user);
           return userRepository.save(user);
       }
    }

    @Override
    public User getUserData(String userEmail) throws UserNotFound {
        if(userRepository.findById(userEmail).isEmpty())
        {
            throw new UserNotFound();
        }
        else
        {
            return userRepository.findById(userEmail).get();
        }
    }

    @Override
    public List<User> getAllUserData() throws UserNotFound {
        if(userRepository.findAll().isEmpty())
        {
            throw new UserNotFound();
        }
        else
        {
            return userRepository.findAll();
        }
    }
}
