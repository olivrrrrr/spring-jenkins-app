//package com.example.demo.RestaurantAPI;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository("restaurants")
//public class  RestaurantDataAccessService implements RestaurantDAO{
//
//    private JdbcTemplate jdbcTemplate;
//
//
//    public RestaurantDataAccessService(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public Optional<Restaurant> getRestaurantByID(long id){
//
//        String sql = """
//                SELECT * FROM restaurant WHERE id = ?;
//                """;
//
//        return jdbcTemplate.query(sql, new RestaurantRowMapper()).stream().findAny();
//    }
//
//    @Override
//    public List<Restaurant> getRestaurants() {
//        return null;
//    }
//}
