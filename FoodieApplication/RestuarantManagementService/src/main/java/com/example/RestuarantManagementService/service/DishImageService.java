package com.example.RestuarantManagementService.service;

import com.example.RestuarantManagementService.model.Image;
import org.springframework.web.multipart.MultipartFile;
<<<<<<< HEAD

import java.util.List;
=======
import org.springframework.core.io.Resource;
>>>>>>> 6db9e26f3effcfb998c101096dc0324145f6893b


public interface DishImageService {

    public void createDirectory();
    public void saveFile(MultipartFile file);
<<<<<<< HEAD
    List<Image> load(String filename);
=======
    Resource load(String filename);
>>>>>>> 6db9e26f3effcfb998c101096dc0324145f6893b
}
