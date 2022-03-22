package com.example.userService;

import com.example.userService.exception.UserAlreadyExist;
import com.example.userService.exception.UserNotFound;
import com.example.userService.model.Address;
import com.example.userService.model.Image;
import com.example.userService.model.User;
import com.example.userService.proxy.UserProxy;
import com.example.userService.repository.UserRepository;
import com.example.userService.service.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserProxy userProxy;

    @InjectMocks
    private UserServiceImpl userService;


    private User user;
    private Image image;
    private Address address;
    List<User> userList;

    @BeforeEach
    private void setUp()
    {
        address=new Address("a001","home","326","villivakkam","chennai","TN",600049,"chennai");
        image=new Image("i001","abc","new");
        user=new User("saravana@gmail.com","saravana","sara","8807264413",image, Collections.singletonList(address));
        userList= Arrays.asList(user);
    }

    @AfterEach
    private void tearDown()
    {
        address=null;
        image=null;
        user=null;
        userRepository.deleteAll();
    }

    @Test
    public void saveUserSuccess() throws UserAlreadyExist {
        when(userRepository.findById(user.getUserMailId())).thenReturn(Optional.ofNullable(null));
        when(userRepository.save(user)).thenReturn(user);
        //doNothing(when(userProxy.saveUser(user)));
        assertEquals(user,userService.registerUser(user));
        verify(userRepository,times(1)).findById(user.getUserMailId());
        verify(userRepository,times(1)).save(user);
        verify(userProxy,times(1)).saveUser(user);
    }

    @Test
    public void saveUserFailure() throws UserAlreadyExist {
        when(userRepository.findById(user.getUserMailId())).thenReturn(Optional.ofNullable(user));
        assertThrows(UserAlreadyExist.class,()->userService.registerUser(user));
        verify(userRepository,times(1)).findById(user.getUserMailId());
        verify(userRepository,times(0)).save(user);
        verify(userProxy,times(0)).saveUser(user);
    }

    @Test
    public  void getAllUserSuccess() throws Exception {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));
        assertEquals(userList,userService.getAllUserData());
        verify(userRepository,times(2)).findAll();
    }

    @Test
    public  void getAllUserFailure() throws Exception {
        when(userRepository.findAll()).thenReturn(null);
        assertThrows(Exception.class,()->userService.getAllUserData());
        verify(userRepository,times(1)).findAll();
    }

    @Test
    public  void getUserSuccess() throws UserNotFound {
        when(userRepository.findById(user.getUserMailId())).thenReturn(Optional.ofNullable(user));
        assertEquals(user,userService.getUserData(user.getUserMailId()));
        verify(userRepository,times(2)).findById(user.getUserMailId());
    }

    @Test
    public  void getUserFailure() throws UserNotFound {
        when(userRepository.findById(user.getUserMailId())).thenReturn(Optional.ofNullable(null));
        assertThrows(UserNotFound.class,()->userService.getUserData(user.getUserMailId()));
        verify(userRepository,times(1)).findById(user.getUserMailId());
    }

}
