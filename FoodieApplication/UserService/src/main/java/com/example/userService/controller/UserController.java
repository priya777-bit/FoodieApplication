package com.example.userService.controller;

import com.example.userService.exception.UserAlreadyExist;
import com.example.userService.exception.UserNotFound;
import com.example.userService.model.Image;
import com.example.userService.model.User;
import com.example.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

   @PostMapping(value = "/registerUser",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE},headers={"Accept=application/json"})
    public ResponseEntity<?> registerUser(@RequestPart("imageFile") MultipartFile file,@RequestPart("uploadData") User user) throws UserAlreadyExist {
        try {
            Image img=new Image(file.getOriginalFilename(),file.getContentType(),file.getBytes());
            System.out.println(img.getImageType());
            user.setImage(img);
            return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
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
