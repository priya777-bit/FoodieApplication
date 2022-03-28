package com.example.userService.service;

import com.example.userService.exception.PathAlreadyExist;
import com.example.userService.model.Image;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileSaveService {

    public Image saveFile(MultipartFile file) throws IOException, PathAlreadyExist;
    public void createDirectory() throws PathAlreadyExist,IOException;
    public Resource load(String filename);
}
