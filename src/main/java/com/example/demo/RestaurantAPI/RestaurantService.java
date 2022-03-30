package com.example.demo.RestaurantAPI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantDAO restaurantDAO;

    @Autowired
    public RestaurantService(@Qualifier("fake")RestaurantDAO restaurantDAO){
        this.restaurantDAO = restaurantDAO;
    }

    public Optional<Restaurant> getRestaurantsByID(long id) {
        return restaurantDAO.getRestaurantByID(id);
    }
}
