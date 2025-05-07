package com.micro.ratings.RatingService.services;

import com.micro.ratings.RatingService.entities.Rating;
import com.micro.ratings.RatingService.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface RatingService {
    Rating create(Rating rating);

    Rating getById(String id);

    List<Rating> getAll();

    List<Rating> getRatingByUserId(String id);

    List<Rating> getRatingByHotelId(String id);

}
