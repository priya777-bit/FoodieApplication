package com.example.addRestuarantService.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUpload {

    public void createDirectory();
    public void saveFile(MultipartFile file);
}
