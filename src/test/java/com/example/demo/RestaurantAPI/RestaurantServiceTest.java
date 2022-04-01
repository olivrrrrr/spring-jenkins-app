package com.example.demo.RestaurantAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestaurantServiceTest {

    private RestaurantDAO restaurantDAO;
    private RestaurantService underTest;

    @BeforeEach
    void setup() {
        restaurantDAO = mock(RestaurantDAO.class);
        underTest = new RestaurantService(restaurantDAO);
    }

    @Test
    void itShouldGetRestaurantsByID() {
        //given
        Restaurant restaurant = new Restaurant(1, "I am pho", "Chinatown");
        Optional<Restaurant> expected = Optional.of(restaurant);
        //when
        when(restaurantDAO.getRestaurantByID(1)).thenReturn(expected);
        Optional<Restaurant> actual = underTest.getRestaurantsByID(1);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void getAllRestaurants() {
        // given
        List<Restaurant> expected =  List.of(new Restaurant(1, "Pho Cho", "Piccadilly"));
        // when
        when(restaurantDAO.getAllRestaurants()).thenReturn(expected);
        List<Restaurant> actual = underTest.getAllRestaurants();
        // then
        assertEquals(expected, actual);
    }

    @Test
    void addRestaurant() {
        // given
        Restaurant restaurant = new Restaurant(2, "Habesha", "Piccadilly");
        int expected = 1;
        //when
        when(restaurantDAO.addRestaurant(restaurant)).thenReturn(1);
        int actual = underTest.addRestaurant(restaurant);

        ArgumentCaptor<Restaurant> restaurantArgumentCaptor = ArgumentCaptor
                .forClass(Restaurant.class);

        verify(restaurantDAO).addRestaurant(restaurantArgumentCaptor.capture());
        Restaurant capturedRestaurant = restaurantArgumentCaptor.getValue();
        //then
        assertEquals(expected, actual);
        assertEquals(restaurant, capturedRestaurant);
    }

    @Test
    void deleteRestaurant() {

        //List<Restaurant> restaurantList = List.of(new Restaurant(2, "Habesha", "Piccadilly"));
        long restaurantId = 1;
        // given
        int expected = 1;

        // when
        when(restaurantDAO.deleteRestaurant(restaurantId)).thenReturn(0);
        int actual = underTest.deleteRestaurant(restaurantId);
        ArgumentCaptor<Long> idArgumentCaptor = ArgumentCaptor
                .forClass(Long.class);
        verify(restaurantDAO).deleteRestaurant(idArgumentCaptor.capture());
        long capturedId = (long) idArgumentCaptor.getValue();
        // then
        assertEquals(expected,actual);
        assertEquals(restaurantId, capturedId);
    }
}