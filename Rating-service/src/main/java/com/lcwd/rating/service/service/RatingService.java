package com.lcwd.rating.service.service;

import java.util.List;

import com.lcwd.rating.service.entities.Rating;

public interface RatingService {
	//create
Rating create(Rating rating);

//get all ratings
List<Rating>getAllRatings();

//get all byUserId
List<Rating>getRatingByUserId(String userId);

//get all by hotel
List<Rating>getRatingByHotelId(String hotelId);
}
