package com.example.demo.RestaurantAPI;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeRestaurantDataAccessService implements RestaurantDAO{

    List<Restaurant> db = new ArrayList<>();

    public FakeRestaurantDataAccessService(){
        db.add(new Restaurant(1, "Macky Mayer", "Manchester"));
    }

    @Override
    public List<Restaurant> getAllRestaurants(){
        return db;
    }

    @Override
    public Optional<Restaurant> getRestaurantByID(long id){
        return db.stream().filter(t -> t.getId() == id).findAny();
    }

    @Override
    public int addRestaurant(Restaurant restaurant){
        db.add(restaurant);
        return 1;
    };

    @Override
    public List<Restaurant> deleteRestaurant(long id){
        db = db.stream().filter(t -> t.getId() != id).toList();
        return db;
    }

}
