package com.example.UserAuthenticationService.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class User {
    @Id
    private String userMailId;
    private String userPassword;
}
