package com.security.user.service;

import com.security.user.service.entities.Rating;
import com.security.user.service.external_services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityPractApplicationTests {

	@Autowired
	private RatingService ratingService;
	@Test
	void contextLoads() {
	}

	@Test
	void testRatingCreation(){
		Rating rating = Rating.builder().rating(5).userId("").hotelId("").feedback("Good").build();
		Rating new_rating=ratingService.create(rating);
		System.out.println(new_rating);
	}
}
