package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.User;
import com.example.myanimelibrary.domain.repositories.UserRepository;
import com.example.myanimelibrary.infrastructure.jparepositories.JPAUserRepository;

import java.util.List;

public class UserRepositoryInfra implements UserRepository {

    private final JPAUserRepository jpaUserRepository;

    public UserRepositoryInfra(JPAUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
