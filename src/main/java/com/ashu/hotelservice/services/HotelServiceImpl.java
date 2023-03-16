package com.ashu.hotelservice.services;

import com.ashu.hotelservice.entities.Hotel;
import com.ashu.hotelservice.exceptions.ResourceNotFoundException;
import com.ashu.hotelservice.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepository hotelRepository;
    public HotelServiceImpl() {
        super();
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        String randomId = UUID.randomUUID().toString();
        hotel.setHotelId(randomId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel Not found with this id!! "+id));
    }
}
