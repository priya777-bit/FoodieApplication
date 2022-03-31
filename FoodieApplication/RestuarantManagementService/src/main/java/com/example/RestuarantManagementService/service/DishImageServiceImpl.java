package com.example.RestuarantManagementService.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.example.RestuarantManagementService.model.Image;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

@Service
public class DishImageServiceImpl implements DishImageService {

    private Path imagePath = Paths.get("imagePath");


    @Override
    @PostConstruct
    public void createDirectory() {
        //@PostConstruct{
            try {
                Files.createDirectories(imagePath);
            } catch (IOException e) {
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

//    public Resource load(String filename) {
//        try {
//            Path file = Paths.get(String.valueOf(imagePath)).resolve(filename);
//            Resource resource = new UrlResource(file.toUri());
//
//            if (resource.exists() || resource.isReadable()) {
//                return resource;
//            } else {
//                throw new RuntimeException("Could not read the file!");
//            }
//        } catch (MalformedURLException e) {
//            throw new RuntimeException("Error: " + e.getMessage());
//        }
//    }

        @Override
        public List<Image> load(String filename) {
            List<Image> dishImages = new ArrayList<>();
            Path file = Paths.get(String.valueOf("upload")).resolve(filename);
            File fileFolder = new File(String.valueOf(file));
//        System.out.println(fileFolder);
            System.out.println("name " + filename);
            if (fileFolder != null) {
                String enCodeBase64 = null;
                try {
                    String extension = FilenameUtils.getExtension(fileFolder.getName());
                    FileInputStream fileInputStream = new FileInputStream(fileFolder);
                    byte[] bytes = new byte[(int) fileFolder.length()];
                    fileInputStream.read(bytes);
                    enCodeBase64 = Base64.getEncoder().encodeToString(bytes);
                    String[] imgId = filename.split("\\.");
                    System.out.println("imgid" + imgId);
                    Image image = new Image(imgId[0], "data:image/" + extension + ";base64," + enCodeBase64);
                    dishImages.add(image);
                    fileInputStream.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("img" + dishImages);
            return dishImages;
        }


    }
