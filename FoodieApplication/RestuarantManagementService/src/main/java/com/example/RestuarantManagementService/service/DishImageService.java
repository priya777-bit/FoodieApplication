package com.example.RestuarantManagementService.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;


public interface DishImageService {

    public void createDirectory();
    public void saveFile(MultipartFile file);
    Resource load(String filename);
}
