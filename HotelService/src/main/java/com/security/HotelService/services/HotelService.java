package com.security.HotelService.services;

import com.security.HotelService.entities.Hotel;
import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();
    Hotel getHotel(String hotelId);
    Hotel create(Hotel hotel);

}
