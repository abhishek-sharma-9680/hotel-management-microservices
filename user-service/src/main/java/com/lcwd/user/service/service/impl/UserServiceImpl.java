package com.lcwd.user.service.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.external.service.HotelServiceClient;
import com.lcwd.user.service.external.service.RatingServiceClient;
import com.lcwd.user.service.repository.UserRepo;
import com.lcwd.user.service.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

	private UserRepo userRepo;
	private HotelServiceClient hotelService;
	private RatingServiceClient ratingServiceClient;
	
	
	@Override
	public User saveUser(User user) {
	String randomUserId=UUID.randomUUID().toString();
	user.setId(randomUserId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User getUser(String id) {
		
		User user= userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user with given id is not found on server !!"+id));
	
		List<Rating>ratings=ratingServiceClient.getAllRating(id);
		
		ratings.forEach(rating->{
		Object hotel=hotelService.getHotel(rating.getHotelId());
		
		rating.setHotelId(id);
		
		});
		user.setRatings(ratings);
		return user;
	
	}

}
