package com.example.RestuarantManagementService.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

@Service
public class DishImageServiceImpl implements DishImageService {

    private Path imagePath = Paths.get("imagePath");


    @Override
    @PostConstruct
    public void createDirectory(){
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

    public Resource load(String filename) {
        try {
            Path file = Paths.get(String.valueOf(imagePath)).resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

}
