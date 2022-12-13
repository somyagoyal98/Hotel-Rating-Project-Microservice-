package com.microservice.hotel.service.services;

import java.util.List;

import com.microservice.hotel.service.entity.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);
	Hotel getHotel(String id);
	List<Hotel> getAllHotels();
}
