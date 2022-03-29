package com.example.RestuarantManagementService.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DishImageServiceImpl implements DishImageService {

    private Path imagePath = Paths.get("imagePath");


    @Override
<<<<<<< HEAD
    @PostConstruct
    public void createDirectory(){
=======
    //@PostConstruct
    public void createDirectory() {
>>>>>>> b840cb22b92bec9b2129e91d83715e410df79aa3
        try {
            Files.createDirectories(imagePath);
        } catch (IOException e){
            throw new RuntimeException("Could not create upload folder!");
        }
    }

    @Override
    public void saveFile(MultipartFile file) {
        try {
            Path root = Paths.get(String.valueOf(imagePath));
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
