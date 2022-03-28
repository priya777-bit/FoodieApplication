package com.example.addRestuarantService.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
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

    @Override
    public Resource load(String filename) {
        try {
            Path file = Paths.get(String.valueOf(uploadPath))
                    .resolve(filename);
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
