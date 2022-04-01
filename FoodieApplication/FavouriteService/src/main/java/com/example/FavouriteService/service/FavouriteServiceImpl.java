package com.example.FavouriteService.service;

import com.example.FavouriteService.exception.FavouriteAlreadyExist;
import com.example.FavouriteService.model.Dish;
import com.example.FavouriteService.model.Favourite;
import com.example.FavouriteService.model.Image;
import com.example.FavouriteService.model.Restaurant;
//import org.apache.commons.io.FilenameUtils;
import com.example.FavouriteService.repository.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class FavouriteServiceImpl implements FavouriteService{

//    @Autowired
//    ServletContext context;
//
//    private Path upload = Paths.get("upload");

    private FavouriteRepository favouriteRepository;

    @Autowired
    public FavouriteServiceImpl(FavouriteRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }

    @Override
    public Favourite addFavourite(Favourite favourite) throws FavouriteAlreadyExist {

        if(favouriteRepository.findById(favourite.getFavouriteId()).isPresent())
        {
             throw new FavouriteAlreadyExist();
        }

        return favouriteRepository.save(favourite);
    }

    @Override
    public List<Favourite> getALlFavourite(String userMailId) {
        return favouriteRepository.findByUserMailId(userMailId);
    }

    @Override
    public boolean removeFromFav(String favouriteId) {
        boolean result = false;
        Favourite favourite = favouriteRepository.findById(favouriteId).get();

        if(favouriteRepository.findById(favouriteId).isPresent())
        {
            favouriteRepository.delete(favourite);
            result = true;
        }

        return result;
    }

    @Override
    public boolean removeDishFromFav(String favouriteId,String dishId) {
        boolean result = false;
        //boolean dishIdPresent = false;
        Favourite favourite = favouriteRepository.findById(favouriteId).get();
        List<Restaurant> restaurantList = favourite.getRestaurantList();
        for(int i = 0; i<restaurantList.size();i++){
            Restaurant restaurant = restaurantList.get(i);
            List<Dish> dishList = restaurantList.get(i).getDishList();
            for(int j =0; j< dishList.size();j++){
                Dish dish = dishList.get(j);
                if(dish.getDishId().equalsIgnoreCase(dishId)){
                    dishList.remove(dish);
                    result = true;
                }
                restaurantList.set(i,restaurant);
            }
            //dishIdPresent = dishList.removeIf(t -> t.getDishId().equals(dishId));
            favourite.setRestaurantList(restaurantList);
            favouriteRepository.save(favourite);
        }
        return result;
    }

    @Override
    public List<Dish> addDishToFav(String favouriteId,String restaurantId,Dish dish) {
        Favourite favourite = favouriteRepository.findById(favouriteId).get();
        List<Restaurant> restaurantList = favouriteRepository.findById(favouriteId).get().getRestaurantList();
//        Restaurant restaurant = null;
        List<Dish> dishList=null;
        System.out.println("www");
        for(int i =0; i<restaurantList.size();i++) {
             Restaurant restaurant = restaurantList.get(i);
            System.out.println(restaurant);
             String restId = restaurant.getRestaurantId();
             if(restId.equalsIgnoreCase(restaurantId)){
                 dishList = restaurantList.get(i).getDishList();
                 for(int j =0;j<dishList.size();j++) {
                     Dish dish1 = dishList.get(j);
                     if (dish1.getDishId().equalsIgnoreCase(dish.getDishId())) {
                         dishList.add(dish);
                         System.out.println(dish);
                         System.out.println("dis1" + dish1);
                     }
                     //restaurantList.se
                 }
             }
            restaurantList.set(i,restaurant);
            favourite.setRestaurantList(restaurantList);
            favouriteRepository.save(favourite);
        }
        return dishList;
    }

//    @Override
//    public List<Image> load(String filename) {
//        List<Image> dishImages = new ArrayList<>();
//        Path file = Paths.get(String.valueOf(upload)).resolve(filename);
//        File fileFolder = new File(String.valueOf(file));
//        if (fileFolder != null) {
//            String enCodeBase64 = null;
//            try {
//                String extension = FilenameUtils.getExtension(fileFolder.getName());
//                FileInputStream fileInputStream = new FileInputStream(fileFolder);
//                byte[] bytes = new byte[(int) fileFolder.length()];
//                fileInputStream.read(bytes);
//                enCodeBase64 = Base64.getEncoder().encodeToString(bytes);
//                String[] imgId = filename.split("\\.");
//                Image image = new Image(imgId[0], "data:image/" + extension + ";base64," + enCodeBase64);
//                dishImages.add(image);
//                fileInputStream.close();
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return dishImages;
//    }
}
