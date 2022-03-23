package com.example.UserAuthenticationService;

import com.example.UserAuthenticationService.model.User;
import com.example.UserAuthenticationService.repository.UserRepository;
import com.example.UserAuthenticationService.service.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    private User user1;

    @BeforeEach
    public void setUp(){
        user1 = new User("pc12@gmail.com","pc123");
    }

    @AfterEach
    public void tearDown(){
        user1 = null;
        userRepository.deleteAll();
    }

    @Test
    public void saveUserSuccess(){
//        when(userRepository.existsById(anyString())).thenReturn(true);
        when(userRepository.save(any(User.class))).thenReturn(user1);
        User saveUser = userRepository.save(user1);
        assertThat(saveUser.getUserMailId()).isNotNull();
    }

    @Test
    public void findByUserMailIdAndUserPasswordSuccess(){
        when(userRepository.findByUserMailIdAndUserPassword(anyString(),anyString())).thenReturn(user1);

    }
}
