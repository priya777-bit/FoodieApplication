package com.example.adminService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Admin {

    @Id
    private String adminEmailId;
    private String adminPassword;
    private String adminName;
    private String adminPhoneNo;
    private Image image;
    private List<Address> addressList;




}
