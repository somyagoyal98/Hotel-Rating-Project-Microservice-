package com.microservice.rating.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.rating.service.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {

	List<Rating> findByHotelId(String hotelId);
	List<Rating> findByUserId(String userId);
}
