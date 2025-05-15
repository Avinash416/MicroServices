package com.security.user.service.services.impl;

import com.security.user.service.entities.Hotel;
import com.security.user.service.entities.Rating;
import com.security.user.service.entities.User;
import com.security.user.service.exceptions.ResourceNotFoundException;
import com.security.user.service.external_services.HotelService;
import com.security.user.service.respositories.UserRepository;
import com.security.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        String randomUUId = UUID.randomUUID().toString();
        user.setUserId(randomUUId);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String userId) {

        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Resource with the given id is not found"+" "+ userId));
        ResponseEntity<List<Rating>> response = restTemplate.exchange(
               "http://RATINGSERVICE/ratings/users/" + user.getUserId(),
               HttpMethod.GET,
               null,
               new ParameterizedTypeReference<>() {
               }
       );

       List<Rating> ratingList = response.getBody();

        assert ratingList != null;
        List<Rating> ratings = ratingList.stream().peek(rating->{
//          Hotel hotel= restTemplate.getForObject("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
           rating.setHotel(hotel);
        }).toList();

        user.setRatings(ratings);
        return user;
    }
}
