package com.example.FavouriteService.service;

import com.example.FavouriteService.exception.FavouriteAlreadyExist;
import com.example.FavouriteService.model.Dish;
import com.example.FavouriteService.model.Favourite;
import com.example.FavouriteService.model.Restaurant;
import com.example.FavouriteService.repository.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteServiceImpl implements FavouriteService{

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
    public List<Dish> addDishToFav(String favouriteId,String restaurantId,Dish dish) {
        Favourite favourite = favouriteRepository.findById(favouriteId).get();
        List<Restaurant> restaurantList = favouriteRepository.findById(favouriteId).get().getRestaurantList();
        List<Dish> dishList=null;
        for(int i =0; i<restaurantList.size();i++) {
            Restaurant restaurant = restaurantList.get(i);
//            System.out.println(restaurant);
            String restId = restaurant.getRestaurantId();
            if(restId.equalsIgnoreCase(restaurantId)){
                dishList = restaurant.getDishList();
                dishList.add(dish);
                restaurantList.set(i,restaurant);
            }
            favourite.setRestaurantList(restaurantList);
            favouriteRepository.save(favourite);
        }
        return dishList;
    }

    @Override
    public boolean removeDishFromFav(String favouriteId,String restaurantId,String dishId) {
        boolean result = false;
        Favourite favourite = favouriteRepository.findById(favouriteId).get();
        List<Restaurant> restaurantList = favourite.getRestaurantList();
        for(int i = 0; i<restaurantList.size();i++){
            Restaurant restaurant = restaurantList.get(i);
            if(restaurant.getRestaurantId().equalsIgnoreCase(restaurantId)) {
                List<Dish> dishList = restaurantList.get(i).getDishList();
//                System.out.println("dishList"+dishList);
                for (int j = 0; j < dishList.size(); j++) {
                    Dish dish = dishList.get(j);
//                    System.out.println("dish"+dish);
//                    System.out.println("dishId"+dishId);
//                    System.out.println("get"+dish.getDishId());
                    if (dish.getDishId().equalsIgnoreCase(dishId)) {
                        result = dishList.remove(dish);
//                        System.out.println(result);
//                        System.out.println("new"+dishList);
                    }
                }
            }
            favouriteRepository.save(favourite);
        }
        return result;
    }

}
