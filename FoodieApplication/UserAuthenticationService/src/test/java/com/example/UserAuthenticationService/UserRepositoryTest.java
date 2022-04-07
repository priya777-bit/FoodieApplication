//package com.example.UserAuthenticationService;
//
//
//import com.example.UserAuthenticationService.model.User;
//import com.example.UserAuthenticationService.repository.UserRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
////@ExtendWith(SpringExtension.class)
////@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    private User user1;
//
//    @BeforeEach
//    public void setUp(){
//        user1 = new User("pc12@gmail.com","pc123");
//    }
//
//    @AfterEach
//    public void tearDown(){
//        user1 = null;
//        userRepository.deleteAll();
//    }
//
//    @Test
//    public void saveUserSuccess(){
//        User saveUser = userRepository.save(user1);
//        assertThat(saveUser).isNotNull();
//    }
//
//
//    @Test
//    public void findByUserMailIdAndUserPasswordSuccess(){
//       User user = userRepository.findByUserMailIdAndUserPassword(user1.getUserMailId(), user1.getUserPassword());
//        assertThat(user1.getUserMailId()).isEqualTo(user1.getUserMailId());
//        assertThat(user1.getUserPassword()).isEqualTo(user1.getUserPassword());
//    }
//
//
//
//}
