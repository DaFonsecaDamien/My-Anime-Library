package com.example.myanimelibrary.domain.service;

import com.example.myanimelibrary.domain.User;
import com.example.myanimelibrary.domain.repositories.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public List<User> getAllUsers() {return userRepository.getAllUsers();}
}
