package com.security.HotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.security.HotelService.entities.Hotel;
public interface HotelRepository extends JpaRepository<Hotel, String> {}