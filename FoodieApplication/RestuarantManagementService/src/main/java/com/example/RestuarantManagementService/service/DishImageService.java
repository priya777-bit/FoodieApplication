package com.example.RestuarantManagementService.service;

import com.example.RestuarantManagementService.model.Image;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import org.springframework.core.io.Resource;
import com.example.RestuarantManagementService.model.Image;

import java.util.List;


public interface DishImageService {

    public void createDirectory();
    public void saveFile(MultipartFile file);
<<<<<<< HEAD
//    Resource load(String filename);
    List<Image> load(String filename);
=======

    List<Image> load(String filename);

    //Resource load(String filename);

>>>>>>> 42890fe7d0123c4ca9e9e90f787dcccdfc3fe910
}
