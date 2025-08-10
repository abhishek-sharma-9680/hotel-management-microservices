package com.lcwd.user.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class Controller {
	
	private UserService userService;
	
	//create
	@PostMapping("/create")
	public ResponseEntity<User>createUser(@RequestBody User user){
		
		User user1=userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	
	//single user get
	@GetMapping("/getById{userId}")
	public ResponseEntity<User>getSingleUser(@PathVariable String userId){
		
		User user=userService.getUser(userId);
		return ResponseEntity.ok(user);
				
	}
	
	//all user get
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUser(){
	
		List<User>allUser=userService.getAllUser();
		return ResponseEntity.ok(allUser);
		
	}

}
