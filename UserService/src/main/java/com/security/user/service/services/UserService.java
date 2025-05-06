package com.security.user.service.services;

import com.security.user.service.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(String userId);
}
