package com.example.userService.model;

import lombok.Data;

@Data
public class Address {
    private String addressId;
    private String addressType;
    private String streetNo;
    private String streetName;
    private String city;
    private String state;
    private long pincode;
    private String landmark;
}
