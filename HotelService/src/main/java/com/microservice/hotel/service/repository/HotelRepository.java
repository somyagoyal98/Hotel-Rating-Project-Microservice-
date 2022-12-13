package com.microservice.hotel.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.hotel.service.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String>{

	
}
