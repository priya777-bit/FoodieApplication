package com.example.RestuarantManagementService.controller;

import com.example.RestuarantManagementService.exception.*;
import com.example.RestuarantManagementService.model.Dish;
import com.example.RestuarantManagementService.model.Image;
import com.example.RestuarantManagementService.model.Restaurant;
import com.example.RestuarantManagementService.model.UploadResponseMessage;
import com.example.RestuarantManagementService.service.DishImageServiceImpl;
import com.example.RestuarantManagementService.service.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;




//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/user/admin")
public class RestaurantController {

    private RestaurantServiceImpl restaurantService;
    private DishImageServiceImpl dishImageService;

    @Autowired
    public RestaurantController(RestaurantServiceImpl restaurantService, DishImageServiceImpl dishImageService) {
        this.restaurantService = restaurantService;
        this.dishImageService=dishImageService;
    }

    @PostMapping("/restaurant/save")
    public ResponseEntity<?> registerRestaurant(@RequestBody Restaurant restaurant) throws RestaurantAlreadyExist{
        try {
            return new ResponseEntity<>(restaurantService.registerRestaurant(restaurant), HttpStatus.CREATED);
        }
        catch (RestaurantAlreadyExist e){
            throw new RestaurantAlreadyExist();
        }
        catch (Exception e){
            return new ResponseEntity<>("Try After SomeTime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public ResponseEntity<?> removeRestaurant(@PathVariable String restaurantId) throws RestaurantNotFound{
        try{
            return new ResponseEntity<>(restaurantService.removeRestaurant(restaurantId),HttpStatus.OK);
        }
        catch (RestaurantNotFound e){
            e.printStackTrace();
            return new ResponseEntity<>("Try After SomeTime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/restaurant/{restaurantId}/dish")
    public ResponseEntity<?> addDishToRestaurant(@PathVariable String restaurantId, @RequestBody Dish dish) throws RestaurantNotFound, DishAlreadyExist{
        try {
            return new ResponseEntity<>(restaurantService.addDishToRestaurant(restaurantId,dish),HttpStatus.CREATED);
        }
        catch (RestaurantNotFound e){
            throw new RestaurantNotFound();
        }
        catch (DishAlreadyExist e){
            throw new DishAlreadyExist();
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Try After SomeTime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/restaurant/{restaurantId}/dish/{dishId}")
    public ResponseEntity<?> removeDishFromRestaurant(@PathVariable String restaurantId,@PathVariable String dishId) throws RestaurantNotFound, DishNotFound{
        try {
            return new ResponseEntity<>(restaurantService.removeDishFromRestaurant(restaurantId,dishId),HttpStatus.OK);
        }
        catch (RestaurantNotFound e){
            throw new RestaurantNotFound();
        }
        catch (DishNotFound e){
            throw new DishNotFound();
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Try After SomeTime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/restaurant/find")
    public ResponseEntity<?> findAllRestaurant(){
        try {
            return new ResponseEntity<>(restaurantService.findAllRestaurant(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Try After SomeTime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/dishImage")
    public ResponseEntity<UploadResponseMessage> uploadFile (@RequestParam("file")MultipartFile file) throws DirectoryAlreadyExist, IOException {
        try {
            System.out.println("post");
            dishImageService.saveFile(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new UploadResponseMessage("Uploaded The File Successfully.." + file.getOriginalFilename()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new UploadResponseMessage("could not upload file .." + file.getOriginalFilename() + "!"));
        }
    }

    @GetMapping("{filename:.+}")
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        List<Image> dishImages = dishImageService.load(filename);
        return new ResponseEntity<>(dishImages,HttpStatus.OK);
    }
}
