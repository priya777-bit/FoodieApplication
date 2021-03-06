package com.example.addRestuarantService.service;

import com.example.addRestuarantService.model.Image;

import org.apache.commons.io.FilenameUtils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ImageUploadImpl implements ImageUpload {

    //    @Value("${upload.path}")
    private Path uploadPath = Paths.get("upload");

//    @Autowired
//    private ServletContext context;

    @Override
    @PostConstruct
    public void createDirectory() {

        try {
            Files.createDirectories(uploadPath);
        } catch (IOException io) {
            throw new RuntimeException("could not create upload folder..");
        }
    }

    @Override
    public void saveFile(MultipartFile file) {

        try {
            Path root = Paths.get(String.valueOf(uploadPath));
            if (!Files.exists(root)) {
                System.out.println("in save file");
                createDirectory();
            }
            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("could not store file. Error" + e.getMessage());
        }
    }

    @Override
    public List<Image> load(String fileName) {

        List<Image> files = new ArrayList<Image>();

        Path filePath = Paths.get(String.valueOf(uploadPath)).resolve(fileName);

        File fileFolder = new File(String.valueOf(filePath));

//        Path file = Paths.get(String.valueOf(path)).resolve(filename);
        //String filePath = context.getRealPath("/upload");
//        File fileFolder = new File(String.valueOf(file));
        System.out.println(fileFolder);

        if (fileFolder != null) {
            String encodeBase64 = null;

            try {
                String extension = FilenameUtils.getExtension(fileFolder.getName());
                FileInputStream fileInputStream = new FileInputStream(fileFolder);
                byte[] bytes = new byte[(int) fileFolder.length()];
                fileInputStream.read(bytes);
                encodeBase64 = Base64.getEncoder().encodeToString(bytes);
                String[] fileId = fileName.split("\\.");
                Image image = new Image(fileId[0],"data:image/" + extension + ";base64," + encodeBase64);
                files.add(image);
                fileInputStream.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return files;
    }
}

//    @Override
//    public Resource load(String filename) {
//        try {
//            Path file = Paths.get(String.valueOf(uploadPath))
//                    .resolve(filename);
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

