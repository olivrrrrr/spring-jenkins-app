package com.example.demo.RestaurantAPI;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RestaurantRowMapper implements RowMapper<Restaurant> {

    @Override
    public Restaurant mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Restaurant(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("location")
        );
    }

}
