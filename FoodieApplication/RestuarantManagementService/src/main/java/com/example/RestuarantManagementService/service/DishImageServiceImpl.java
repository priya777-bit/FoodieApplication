//package com.example.RestuarantManagementService.service;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.PostConstruct;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@Service
//public class DishImageServiceImpl implements DishImageService{
//
//    private final Path path = Paths.get("upload");
//
//    @Override
//    public void saveFile(MultipartFile file) {
//        try {
//            if(!Files.exists(path)){
//                System.out.println("In Save File");
//                createDirectory();
//            }
//            Files.copy(file.getInputStream(),this.path.resolve(file.getOriginalFilename()));
//        }
//        catch (Exception e){
//            throw new RuntimeException("could not store file , Error" +e.getMessage());
//        }
//    }
//
//    @Override
//    @PostConstruct
//    public void createDirectory() {
//        try {
//            Files.createDirectory(path);
//        } catch (IOException e){
//            throw new RuntimeException("Could not create upload folder!");
//        }
//
//    }
//}
