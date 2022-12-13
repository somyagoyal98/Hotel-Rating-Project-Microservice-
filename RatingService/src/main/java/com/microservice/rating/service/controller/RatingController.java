package com.microservice.rating.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.rating.service.entity.Rating;
import com.microservice.rating.service.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		Rating rating1 = ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
	}

	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getRating(@PathVariable String ratingId) {
		Rating rating = ratingService.getRating(ratingId);
		return ResponseEntity.ok(rating);
	}

	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings() {
		List<Rating> allRatings = ratingService.getAllRatings();
		return ResponseEntity.ok(allRatings);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
		List<Rating> ratings = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(ratings);
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
		List<Rating> ratings = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(ratings);
	}
	

}
