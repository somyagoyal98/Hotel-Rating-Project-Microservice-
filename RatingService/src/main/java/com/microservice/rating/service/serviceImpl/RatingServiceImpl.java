package com.microservice.rating.service.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.rating.service.entity.Rating;
import com.microservice.rating.service.exception.ResourceNotFoundException;
import com.microservice.rating.service.repository.RatingRepository;
import com.microservice.rating.service.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepo;
	@Override
	public Rating createRating(Rating rating) {
		String randomRatingId = UUID.randomUUID().toString();
		rating.setRatingId(randomRatingId);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepo.findAll();
	}

	@Override
	public Rating getRating(String ratingId) {
		return ratingRepo.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Rating with this id "+ratingId+" is not found!!"));
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

	
}
