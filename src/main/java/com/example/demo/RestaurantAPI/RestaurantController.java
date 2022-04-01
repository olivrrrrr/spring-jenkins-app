package com.example.demo.RestaurantAPI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void addRestaurant(@RequestBody Restaurant restaurant){
         restaurantService.addRestaurant(restaurant);
    };

    @DeleteMapping("{id}")
    public void deleteRestaurant(@PathVariable("id") long id){
        restaurantService.deleteRestaurant(id);
    }

}
