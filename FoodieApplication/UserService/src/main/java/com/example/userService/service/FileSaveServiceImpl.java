package com.example.userService.service;

import com.example.userService.exception.PathAlreadyExist;
import com.example.userService.model.Image;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileSaveServiceImpl implements FileSaveService {

    private final Path path= Paths.get("upload");
    @Override
    public Image saveFile(MultipartFile file) throws IOException, PathAlreadyExist {
        Path root=Paths.get(String.valueOf(path));
//        Path path1 = Paths.get("/upload");
//        System.out.printf("%-25s : %s%n", "file.getPath()", file.getPath());
//        System.out.printf("%-25s : %s%n", "file.getAbsolutePath()",
//                file.getAbsolutePath());
        if(!Files.exists(root))
        {
            createDirectory();
        }
        Files.copy(file.getInputStream(),this.path.resolve(file.getOriginalFilename()));
        Image img=new Image(file.getOriginalFilename(),file.getContentType(),file.getBytes());
        return img;
    }

    @Override
    public void createDirectory() throws IOException, PathAlreadyExist {
        Files.createDirectory(path);

    }
    @Override
    public Resource load(String filename) {
        try {
            Path file = Paths.get(String.valueOf(path))
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
