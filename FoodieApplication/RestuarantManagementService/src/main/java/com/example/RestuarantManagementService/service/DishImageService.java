package com.example.RestuarantManagementService.service;

import com.example.RestuarantManagementService.model.Image;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import org.springframework.core.io.Resource;


public interface DishImageService {

    public void createDirectory();
    public void saveFile(MultipartFile file);

    List<Image> load(String filename);

    //Resource load(String filename);

}
