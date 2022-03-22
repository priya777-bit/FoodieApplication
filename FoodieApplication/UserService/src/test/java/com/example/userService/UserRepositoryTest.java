package com.example.userService;

import com.example.userService.model.Address;
import com.example.userService.model.Image;
import com.example.userService.model.User;
import com.example.userService.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;
    private Image image;
    private Address address;

    @BeforeEach
    private void setUp()
    {
        address=new Address("a001","home","326","villivakkam","chennai","TN",600049,"chennai");
        image=new Image("i001","abc","new");
        user=new User("saravana@gmail.com","saravana","sara","8807264413",image, Collections.singletonList(address));
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
    public void saveUserSuccess()
    {
        userRepository.insert(user);
        User user1=userRepository.findById(user.getUserMailId()).get();
        assertEquals(user1.getUserMailId(),user.getUserMailId());
    }

    @Test
    public void saveUserFailure()
    {
        userRepository.insert(user);
        User user1=userRepository.findById(user.getUserMailId()).get();
        assertNotEquals(user1.getUserMailId(),"user.getUserMailId()");
    }

    @Test
    public void getUserSuccess(){
        userRepository.insert(user);
        User user1=userRepository.findById(user.getUserMailId()).get();
        assertEquals("saravana@gmail.com", user1.getUserMailId());
    }

    @Test
    public void getAllUserSuccess(){
        userRepository.insert(user);
        List<User> usersList=userRepository.findAll();
        assertEquals(1,usersList.size());
        assertEquals("saravana@gmail.com", usersList.get(0).getUserMailId());
    }

}
