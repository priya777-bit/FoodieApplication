package com.example.addRestuarantService.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.example.addRestuarantService.model.Image;

//import java.awt.*;
import java.util.List;

public interface ImageUpload {

    public void createDirectory();
    public void saveFile(MultipartFile file);
//    public Resource load(String filename);
    public List<Image> load(String fileName);
}
