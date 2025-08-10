package com.lcwd.hotel.service.exceptions;

public class ResourceNotFoundException extends Exception{

	public ResourceNotFoundException() {
		super("Resource not found on server !!");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}
