package com.security.user.service.external_services;

import com.security.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

    @PostMapping("/ratings")
    Rating create(@RequestBody Rating rating);

    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(@PathVariable String ratingId, @RequestBody Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    void deleteRating(@PathVariable String ratingId);
}
