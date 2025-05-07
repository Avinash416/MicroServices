package com.micro.ratings.RatingService.services.impls;

import com.micro.ratings.RatingService.entities.Rating;
import com.micro.ratings.RatingService.exceptions.ResourceNotFoundException;
import com.micro.ratings.RatingService.repositories.RatingRepository;
import com.micro.ratings.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatingByUserId(String id) {
        return ratingRepository.findByUserId(id);
    }

    @Override
    public List<Rating> getRatingByHotelId(String id) {
        return ratingRepository.findByHotelId(id);
    }

    @Override
    public Rating getById(String id) {
        return ratingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not found for this Id"+ " " +id));
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }
}
