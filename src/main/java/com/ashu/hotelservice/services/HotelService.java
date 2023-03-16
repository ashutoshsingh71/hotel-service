package com.ashu.hotelservice.services;

import com.ashu.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotel(String id);
}
