package com.example.demo.RestaurantAPI;

import java.util.List;
import java.util.Optional;

public interface RestaurantDAO {
    Optional<Restaurant> getRestaurantByID(long id);
    List<Restaurant> getAllRestaurants();
    int addRestaurant(Restaurant restaurant);
    int deleteRestaurant(long id);
}
