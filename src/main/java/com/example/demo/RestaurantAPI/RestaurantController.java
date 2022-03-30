package com.example.demo.RestaurantAPI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @GetMapping("{id}")
    public Optional<Restaurant> getRestaurantsByID(@PathVariable("id") long id){
        return restaurantService.getRestaurantsByID(id);
    }

    @GetMapping("/all")
    public List<Restaurant>  getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }


}
