package com.example.addRestuarantService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private String imageName;
    private String imageUrl;
    private long imageSpec;

}
