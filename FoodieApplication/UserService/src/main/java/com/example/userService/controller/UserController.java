package com.example.userService.controller;

import com.example.userService.exception.PathAlreadyExist;
import com.example.userService.exception.UserAlreadyExist;
import com.example.userService.exception.UserNotFound;
import com.example.userService.model.Image;
import com.example.userService.model.User;
import com.example.userService.service.FileSaveService;
import com.example.userService.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

@RestController
@RequestMapping("/api/user/v2")
public class UserController {

    private UserService userService;
    private FileSaveService fileSaveService;

    @Autowired
    public UserController(UserService userService,FileSaveService fileSaveService) {
        this.userService = userService;
        this.fileSaveService=fileSaveService;
    }

    @PostMapping(value = "/registerUser")//,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE},headers={"Accept=application/json"})
    public ResponseEntity<?> registerUser(@RequestParam("imageFile") MultipartFile file,@RequestParam("uploadData") String user) throws UserAlreadyExist {
        try {
            User user1= new ObjectMapper().readValue(user,User.class);
            //Image img=new Image(file.getOriginalFilename(),file.getContentType(),file.getBytes());
            Image img=fileSaveService.saveFile(file);
            user1.setImage(img);
            return new ResponseEntity<>(userService.registerUser(user1), HttpStatus.CREATED);
        }
        catch (UserAlreadyExist error)
        {
            throw new UserAlreadyExist();
        }
        catch (Exception error)
        {
            System.out.println(error);
            return new ResponseEntity<>("try after some time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/userImage")
    public ResponseEntity<?> userImage(@RequestParam("file") MultipartFile file) throws IOException, PathAlreadyExist {
        return new ResponseEntity<>(fileSaveService.saveFile(file), HttpStatus.OK);
    }

    @GetMapping("/users/{filename}")
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        Resource file = fileSaveService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);

    }



    @GetMapping("/users/getUserProfile/{userEmail}")
    public ResponseEntity<?> getUserProfile(@PathVariable String userEmail) throws UserNotFound {
        try {
            return new ResponseEntity<>(userService.getUserData(userEmail), HttpStatus.OK);
        }
        catch (UserNotFound error)
        {
            throw new UserNotFound();
        }
        catch (Exception error)
        {
            return new ResponseEntity<>("try after some time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/admin/getAllUserProfile")
    public ResponseEntity<?> getAllUserProfile() throws UserNotFound {
        try {
            return new ResponseEntity<>(userService.getAllUserData(), HttpStatus.OK);
        }
        catch (UserNotFound error)
        {
            throw new UserNotFound();
        }
        catch (Exception error)
        {
            return new ResponseEntity<>("try after some time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
