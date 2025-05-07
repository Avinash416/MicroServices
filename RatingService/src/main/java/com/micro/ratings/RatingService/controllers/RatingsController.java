package com.micro.ratings.RatingService.controllers;

import com.micro.ratings.RatingService.entities.Rating;
import com.micro.ratings.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAll(){
        return ResponseEntity.ok().body(ratingService.getAll());
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getById(@PathVariable String ratingId){
        return ResponseEntity.ok().body(ratingService.getById(ratingId));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getByUserId(@PathVariable String userId ){
        return ResponseEntity.ok().body(ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}" )
    public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String hotelId ){
        return ResponseEntity.ok().body(ratingService.getRatingByHotelId(hotelId));
    }
}
