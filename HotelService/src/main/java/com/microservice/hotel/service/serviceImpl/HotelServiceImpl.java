package com.microservice.hotel.service.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hotel.service.entity.Hotel;
import com.microservice.hotel.service.exception.ResourceNotFoundException;
import com.microservice.hotel.service.repository.HotelRepository;
import com.microservice.hotel.service.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String randomHotelId = UUID.randomUUID().toString();
		hotel.setHotelId(randomHotelId);
		return hotelRepo.save(hotel);
	}

	@Override
	public Hotel getHotel(String id) {
		return hotelRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel with given id " + id + " is not found!!"));
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepo.findAll();
	}

}
