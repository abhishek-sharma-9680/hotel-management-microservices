package com.lcwd.user.service.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcwd.user.service.entities.Rating;

@FeignClient(name="Rating-service")
public interface RatingServiceClient {
    
	@GetMapping("/ratings/getAll/byUserId/{userId}")
	List<Rating>getAllRating(@PathVariable("userId") String id);
}
