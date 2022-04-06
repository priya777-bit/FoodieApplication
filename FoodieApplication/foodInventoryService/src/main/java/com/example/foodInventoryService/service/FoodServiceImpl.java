package com.example.foodInventoryService.service;

import com.example.foodInventoryService.model.Dish;
import com.example.foodInventoryService.model.Image;
import com.example.foodInventoryService.model.Restaurant;
import com.example.foodInventoryService.repository.FoodRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    private FoodRepository foodRepository;

    @Autowired
    ServletContext context;

    private final Path path = Paths.get("upload");

    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return foodRepository.save(restaurant);
    }

    @Override
    public List<Dish> saveDish(String restaurantId, Dish dish) {
        Restaurant restaurant = foodRepository.findById(restaurantId).get();
        System.out.println(restaurant);

        List<Dish> dishList = restaurant.getDishList();
        if (dishList != null) {

            List<Dish> dishList1 = new ArrayList<>(restaurant.getDishList());
            dishList1.add(dish);
            dishList = dishList1;
            restaurant.setDishList(dishList);
        } else {
            System.out.println("listsavedagain");
            restaurant.setDishList(Arrays.asList(dish));
        }
        System.out.println("return");
        foodRepository.save(restaurant);
        return dishList;

//        List<Dish> dishList = restaurant.getDishList();
//        System.out.println("restaurant");
//                    List<Dish> dishList1 = new ArrayList<>(restaurant.getDishList());
//                    dishList1.add(dish);
//                    dishList=dishList1;
//        System.out.println("restaurant");
//                    restaurant.setDishList(dishList);
//
//        foodRepository.save(restaurant);
//        return dishList;
    }

    @Override
    public List<Restaurant> getAllData() {
        return foodRepository.findAll();
    }

    @Override
    public List<Dish> getDishData(String restaurantId) {
        Restaurant restaurant = foodRepository.findById(restaurantId).get();
        List<Dish> dishList = restaurant.getDishList();
        return dishList;
    }

    @Override
    public List<Image> load(String filename) {
        List<Image> images = new ArrayList<>();
        Path file = Paths.get(String.valueOf(path)).resolve(filename);
        //String filePath = context.getRealPath("/upload");
        File fileFolder = new File(String.valueOf(file));
        System.out.println(fileFolder);
        if (fileFolder != null) {

                    String enCodeBase64 = null;
                    try {
                        String extension = FilenameUtils.getExtension(fileFolder.getName());
                        FileInputStream fileInputStream = new FileInputStream(fileFolder);
                        byte[] bytes = new byte[(int) fileFolder.length()];
                        fileInputStream.read(bytes);
                        enCodeBase64 = Base64.getEncoder().encodeToString(bytes);
                        String[] fileId = filename.split("\\.");
                        Image img=new Image(fileId[0],"data:image/" + extension + ";base64," + enCodeBase64);
                        images.add(img);
                       // images.add("data:image/" + extension + ";base64," + enCodeBase64);
                        fileInputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
            }
        }
        return images;
    }
    @Override
    public Restaurant getRestaurant(String restaurantId) {
        return this.foodRepository.findById(restaurantId).get();
    }
}
