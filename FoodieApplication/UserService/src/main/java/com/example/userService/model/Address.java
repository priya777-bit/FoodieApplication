package com.example.userService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address  {
    private String addressId;
    private String addressType;
    private String streetNo;
    private String streetName;
    private String city;
    private String state;
    private long pincode;
    private String landmark;
}
