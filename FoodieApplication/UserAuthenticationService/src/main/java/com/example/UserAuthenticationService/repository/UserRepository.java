package com.example.UserAuthenticationService.repository;

import com.example.UserAuthenticationService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    User findByUserMailIdAndUserPassword(String userMailId,String userPassword);

}
