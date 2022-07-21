package com.example.myanimelibrary.domain.repositories;

import com.example.myanimelibrary.domain.User;

import java.util.List;

public interface UserRepository {
    User saveUser(User user);
    User getUserByUsername(String username);
    List<User> getAllUsers();
}
