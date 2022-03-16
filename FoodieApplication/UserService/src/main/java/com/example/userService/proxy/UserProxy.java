package com.example.userService.proxy;

import com.example.userService.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-authentication-service",url="localhost:8086/api/userAuthentication")
public interface UserProxy {

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody User user);
}
