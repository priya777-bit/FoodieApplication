package com.example.foodInventoryService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    private String imageId;
    private String imageUrl;
    private long imageSpecs;
}
