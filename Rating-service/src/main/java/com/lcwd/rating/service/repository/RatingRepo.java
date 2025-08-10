package com.lcwd.rating.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.rating.service.entities.Rating;
@Repository
public interface RatingRepo extends JpaRepository<Rating, String>{

//custom finder
	
List<Rating>findByHotelId(String hotelId);	
List<Rating>findByUserId(String userId);
	
}
