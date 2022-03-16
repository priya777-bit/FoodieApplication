package com.example.userService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class User {
    @Id
    private String userMailId;
    private String userName;
    private String userPassword;
    private String userPhoneNo;
    private Image image;
    private List<Address> addressList;
}
