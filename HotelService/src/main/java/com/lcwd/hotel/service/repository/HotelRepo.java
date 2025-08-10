package com.lcwd.hotel.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.hotel.service.entities.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, String> {

}
