package com.example.RestuarantManagementService.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DishImageServiceImpl implements DishImageService{

    private final Path uploadPath = Paths.get("upload");


    @Override
    //@PostConstruct
    public void createDirectory() {
        try {
            Files.createDirectory(uploadPath);
        } catch (IOException e){
            throw new RuntimeException("Could not create upload folder!");
        }
    }

    @Override
    public void saveFile(MultipartFile file) {
        try {
            Path root = Paths.get(String.valueOf(uploadPath));
            if(!Files.exists(root)){
                System.out.println("In Save File");
                createDirectory();
            }
            Files.copy(file.getInputStream(),root.resolve(file.getOriginalFilename()));
        }
        catch (Exception e){
            throw new RuntimeException("could not store file , Error" +e.getMessage());
        }
    }

}
