package com.lcwd.hotel.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.service.entities.Hotel;
import com.lcwd.hotel.service.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.service.service.HotelService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/hotel")
public class Controller {
	private HotelService hotelService;
	
	
	@PostMapping("/create")
	public ResponseEntity<Hotel>create(@RequestBody Hotel hotel){
		
		Hotel hotel1=hotelService.create(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
		
	}
	
	@GetMapping("/getById{id}")
	public ResponseEntity<Hotel>getById(@PathVariable String id) throws ResourceNotFoundException{
		Hotel hotel=hotelService.getById(id);
		return ResponseEntity.ok(hotel);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Hotel>> getAll(){
		List<Hotel>hotels=hotelService.getAll();
		return ResponseEntity.ok(hotels);
	}
	

}
