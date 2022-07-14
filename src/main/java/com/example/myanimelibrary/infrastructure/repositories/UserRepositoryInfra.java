package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.User;
import com.example.myanimelibrary.domain.repositories.UserRepository;
import com.example.myanimelibrary.infrastructure.entities.UserEntity;
import com.example.myanimelibrary.infrastructure.jparepositories.JPAUserRepository;
import com.example.myanimelibrary.infrastructure.mapper.UserMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Primary
public class UserRepositoryInfra implements UserRepository {

    private final JPAUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    public UserRepositoryInfra(JPAUserRepository jpaUserRepository, UserMapper userMapper) {
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User saveUser(User user) {
        UserEntity userSaved = jpaUserRepository.save(userMapper.fromModelToEntity(user));
        return userMapper.fromEntityToModel(userSaved);
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
