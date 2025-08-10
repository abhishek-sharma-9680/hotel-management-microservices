package com.lcwd.rating.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.service.entities.Rating;
import com.lcwd.rating.service.service.RatingService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/ratings")

public class Controller {

private RatingService ratingService;

@PostMapping("/create")
public ResponseEntity<Rating>create(@RequestBody Rating rating){	

	Rating rating1=ratingService.create(rating);
	
	return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
	
}
@GetMapping("/getAll")
public ResponseEntity<List<Rating>>getAll(){
	return ResponseEntity.ok(ratingService.getAllRatings());
}

@GetMapping("/getAll/byUserId/{userId}")
public ResponseEntity<List<Rating>>getAllByUSerId(@PathVariable String userId){
	return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
}

@GetMapping("/getAll/byHotelId/{hotelId}")
public ResponseEntity<List<Rating>>getAllByHotelId(@PathVariable String hotelId){
	return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
}
	
}
