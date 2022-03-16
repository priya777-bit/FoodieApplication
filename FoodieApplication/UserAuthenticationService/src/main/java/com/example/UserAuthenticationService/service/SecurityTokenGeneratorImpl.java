package com.example.UserAuthenticationService.service;

import com.example.UserAuthenticationService.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(User user) {
        String jwtToken= Jwts.builder().setSubject(user.getUserMailId())
                .setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,"secretKey").compact();
        Map<String,String>map=new HashMap<>();
        map.put("token",jwtToken);
        map.put("message","User successfully logged in");
        return map;
    }
}
