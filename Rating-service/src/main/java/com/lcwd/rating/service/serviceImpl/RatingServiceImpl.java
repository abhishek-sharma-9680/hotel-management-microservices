package com.lcwd.rating.service.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.lcwd.rating.service.entities.Rating;
import com.lcwd.rating.service.repository.RatingRepo;
import com.lcwd.rating.service.service.RatingService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService{

	private RatingRepo ratingRepo;
	
	@Override
	public Rating create(Rating rating) {
		
		String randomId=UUID.randomUUID().toString();
		rating.setRatingId(randomId);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepo.findAll();
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
