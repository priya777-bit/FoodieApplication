package com.example.adminService.model;


import lombok.Data;

@Data
public class Address {

    private String addressId;
    private String addressType;
    private String streetNo;
    private String streetName;
    private long pinCode;
    private String city;
    private String state;
    private String landmark;
}
