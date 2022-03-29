package com.example.RestuarantManagementService.service;

import org.springframework.web.multipart.MultipartFile;



public interface DishImageService {

    public void createDirectory();
    public void saveFile(MultipartFile file);
}
