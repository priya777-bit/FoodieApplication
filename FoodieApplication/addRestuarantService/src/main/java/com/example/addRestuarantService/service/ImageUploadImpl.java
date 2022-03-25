package com.example.addRestuarantService.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageUploadImpl implements ImageUpload{

//    @Value("${upload.path}")
    private Path uploadPath = Paths.get("upload");

    @Override
    @PostConstruct
    public void createDirectory() {

        try
        {
            Files.createDirectories(uploadPath);
        }
        catch (IOException io)
        {
            throw new RuntimeException("could not create upload folder..");
        }
    }

    @Override
    public void saveFile(MultipartFile file) {

        try
        {
            Path root = Paths.get(String.valueOf(uploadPath));
            if (!Files.exists(root))
            {
                System.out.println("in save file");
                createDirectory();
            }
            Files.copy(file.getInputStream(),root.resolve(file.getOriginalFilename()));
        }
        catch (Exception e)
        {
            throw new RuntimeException("could not store file. Error" +e.getMessage());
        }

    }
}
