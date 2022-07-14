package com.example.myanimelibrary.domain.service;

import com.example.myanimelibrary.domain.User;
import com.example.myanimelibrary.domain.repositories.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
