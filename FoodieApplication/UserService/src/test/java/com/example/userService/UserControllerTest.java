package com.example.userService;

import com.example.userService.controller.UserController;
import com.example.userService.exception.UserAlreadyExist;
import com.example.userService.exception.UserNotFound;
import com.example.userService.model.Address;
import com.example.userService.model.Image;
import com.example.userService.model.User;
import com.example.userService.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;



    @Autowired
    private MockMvc mockMvc;

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
        mockMvc= MockMvcBuilders.standaloneSetup(userController).build();
    }

    @AfterEach
    private void tearDown()
    {
        address=null;
        image=null;
        user=null;
    }

    @Test
    public  void saveUserSuccess() throws Exception {
        when(userService.registerUser(any())).thenReturn(user);
        mockMvc.perform(post("/api/user/registerUser").contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(user))).andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
        verify(userService,times(1)).registerUser(any());
    }

    @Test
    public  void saveUserFailure() throws Exception {
        when(userService.registerUser(any())).thenThrow(UserAlreadyExist.class);
        mockMvc.perform(post("/api/user/registerUser").contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(user))).andExpect(status().isAlreadyReported()).andDo(MockMvcResultHandlers.print());
        verify(userService,times(1)).registerUser(any());
    }

    @Test
    public  void getUserSuccess() throws Exception {
        when(userService.getUserData(user.getUserMailId())).thenReturn(user);
        mockMvc.perform(get("/api/user/users/getUserProfile/saravana@gmail.com").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(userService,times(1)).getUserData(user.getUserMailId());
    }

    @Test
    public  void getUserFailure() throws Exception {
        when(userService.getUserData(user.getUserMailId())).thenThrow(UserNotFound.class);
        mockMvc.perform(get("/api/user/users/getUserProfile/saravana@gmail.com").contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
        verify(userService,times(1)).getUserData(user.getUserMailId());
    }

    @Test
    public  void getAllUserSuccess() throws Exception {
        when(userService.getAllUserData()).thenReturn(Arrays.asList(user));
        mockMvc.perform(get("/api/user/admin/getAllUserProfile").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(userService,times(1)).getAllUserData();
    }

    @Test
    public  void getAllUserFailure() throws Exception {
        when(userService.getAllUserData()).thenThrow(UserNotFound.class);
        mockMvc.perform(get("/api/user/admin/getAllUserProfile").contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
        verify(userService,times(1)).getAllUserData();
    }

    private static String jsonToString(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        String data=objectMapper.writeValueAsString(obj);
        return data;
    }
}
