package com.example.RestuarantManagementService.service;

import com.example.RestuarantManagementService.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FilenameUtils;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;



@Service
public class DishImageServiceImpl implements DishImageService {

    @Autowired
    ServletContext context;

    private Path upload = Paths.get("upload");
    //private Path imagePath = Paths.get("imagePath");


    @Override
    @PostConstruct
    public void createDirectory(){
        try {
            Files.createDirectories(upload);
        } catch (IOException e){
            throw new RuntimeException("Could not create upload folder!");
        }
    }

    @Override
    public void saveFile(MultipartFile file) {
        try {
            Path root = Paths.get(String.valueOf(upload));
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


    @Override
    public List<Image> load(String filename) {
        List<Image> dishImages = new ArrayList<>();
        Path file = Paths.get(String.valueOf(upload)).resolve(filename);
        File fileFolder = new File(String.valueOf(file));
//        System.out.println(fileFolder);
//        System.out.println("name " + filename);
        if (fileFolder != null) {
            String enCodeBase64 = null;
            try {
                String extension = FilenameUtils.getExtension(fileFolder.getName());
                FileInputStream fileInputStream = new FileInputStream(fileFolder);
                byte[] bytes = new byte[(int) fileFolder.length()];
                fileInputStream.read(bytes);
                enCodeBase64 = Base64.getEncoder().encodeToString(bytes);
                String[] imgId = filename.split("\\.");
//                System.out.println("imgid" + imgId);
                Image image = new Image(imgId[0], "data:image/" + extension + ";base64," + enCodeBase64);
                dishImages.add(image);
                fileInputStream.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dishImages;
    }

}
