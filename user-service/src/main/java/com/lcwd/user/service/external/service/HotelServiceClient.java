package com.lcwd.user.service.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HotelService")
public interface HotelServiceClient {
	
	@GetMapping("/hotel/getById{id}")
	Object getHotel(@PathVariable(name="id") String hotelId);

}
