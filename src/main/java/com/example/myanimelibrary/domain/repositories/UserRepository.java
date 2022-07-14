package com.example.myanimelibrary.domain.repositories;

import com.example.myanimelibrary.domain.User;

import java.util.List;

public interface UserRepository {
    User saveUser(User user);
    User getUserByLogin(String login);
    List<User> getAllUsers();
}
