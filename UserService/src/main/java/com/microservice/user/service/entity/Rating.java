package com.microservice.user.service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

	private String ratingId;
	private int rating;
	private String hotelId;
	private String review;
	private Hotel hotel;
}
