package com.security.user.service.controllers;

import com.security.user.service.entities.User;
import com.security.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User userToSave = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userToSave);
    }

    @GetMapping("/{userId}")
    //With the help of circuit breaker we can handle the exception and provide a fallback method in case of any failure.
//    @CircuitBreaker(name ="ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")

//    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    //with the help of retry annotation we can handle the retry logic and provide a fallback method in case of any failure.


    //with the help of rate limiter we can limit the number of requests to a particular service.
    //which will help in security and performance.
    @RateLimiter(name="userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        User user = userService.getUserById(userId);
         return ResponseEntity.ok(user);
    }

    //fallback method for ratingHotelBreaker
    //This method will be called when the above getUser() method fails.
    //Always make sure that this method has same parameters and return type as the actual method.
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
     User user= User.builder().userId("23e213r2").name("Default Name").email("default@gmail.com").about("default about").build();
     return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users =userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
