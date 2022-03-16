package com.example.UserAuthenticationService.service;

import com.example.UserAuthenticationService.exception.UserAlreadyExist;
import com.example.UserAuthenticationService.exception.UserNotFound;
import com.example.UserAuthenticationService.model.User;
import com.example.UserAuthenticationService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExist {
        if(userRepository.existsById(user.getUserMailId()))
        {
            throw new UserAlreadyExist();
        }
        else
        {
            return userRepository.save(user);
        }
    }

    @Override
    public User findByUserMailIdAndUserPassword(String userMailId, String userPassword) throws UserNotFound {
        if(userRepository.findById(userMailId).isEmpty())
        {
            throw new UserNotFound();
        }
        else
        {
            return userRepository.findByUserMailIdAndUserPassword(userMailId,userPassword);
        }
    }
}
