package com.microservice.rating.service.services;

import java.util.List;

import com.microservice.rating.service.entity.Rating;

public interface RatingService {

	Rating createRating(Rating rating);

	List<Rating> getAllRatings();

	Rating getRating(String ratingId);

	List<Rating> getRatingByUserId(String userId);

	List<Rating> getRatingByHotelId(String hotelId);
}
