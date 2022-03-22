package com.example.userService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    private String imageId;
    private String imageURL;
    private String imageSpecs;
}
