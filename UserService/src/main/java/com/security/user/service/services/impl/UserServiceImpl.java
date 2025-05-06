package com.security.user.service.services.impl;

import com.security.user.service.entities.User;
import com.security.user.service.exceptions.ResourceNotFoundException;
import com.security.user.service.respositories.UserRepository;
import com.security.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

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
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Resource with the given id is not found"+" "+ userId));
    }
}
