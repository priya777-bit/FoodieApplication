package com.example.addRestuarantService.controller;


import com.example.addRestuarantService.model.Dish;
import com.example.addRestuarantService.model.Restaurant;
import com.example.addRestuarantService.model.UploadResponseMessage;
import com.example.addRestuarantService.service.ImageUploadImpl;
import com.example.addRestuarantService.service.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/request")
public class RestaurantController {

    private RestaurantServiceImpl restaurantService;
    private ImageUploadImpl imageUpload;

    @Autowired
    public RestaurantController(RestaurantServiceImpl restaurantService,ImageUploadImpl imageUpload) {
        this.restaurantService = restaurantService;
        this.imageUpload=imageUpload;
    }

    @PostMapping("/restaurant")
    public ResponseEntity<?> addRestaurant(@RequestBody Restaurant restaurant){
        try
        {
            return new ResponseEntity<>(restaurantService.addRestaurant(restaurant),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("try again some time ..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{restaurantId}/dish")
    public ResponseEntity<?> addDish(@PathVariable String  restaurantId, @RequestBody Dish dish){
        try {
            System.out.println(restaurantId);
            return new ResponseEntity<>(restaurantService.addDish(restaurantId,dish),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("try again some time ..",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/restaurant/find")
    public ResponseEntity<?> findAllRestaurant(){
        try {
            return new ResponseEntity<>(restaurantService.findAllRestaurant(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Try After Some Time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/restaurant/{restaurantId")
    public ResponseEntity<?> deleteRestaurantWhenRejected(@PathVariable String restaurantId)
    {
        try
        {
            return new ResponseEntity<>(restaurantService.deleteRestaurantWhenRejected(restaurantId),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Try again some time ..",HttpStatus.OK);
        }
    }

    @PostMapping("/restaurant/files")
    public ResponseEntity<UploadResponseMessage> uploadFile(@RequestParam("file")MultipartFile file) {
        try {
            System.out.println("post");
            imageUpload.saveFile(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new UploadResponseMessage("Uploaded The File Successfully.." + file.getOriginalFilename()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new UploadResponseMessage("could not upload file .." + file.getOriginalFilename() + "!"));
        }
    }

    @GetMapping("/restaurant/{restaurantName}/{restaurantLocation}")
    public ResponseEntity<?> findByRestaurantNameAndRestaurantLocation(@PathVariable String restaurantName,@PathVariable String restaurantLocation){
        try {
            return new ResponseEntity<>(restaurantService.findByRestaurantNameAndRestaurantLocation(restaurantName,restaurantLocation),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Try After SomeTime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
