package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.User;
import com.example.myanimelibrary.domain.repositories.UserRepository;
import com.example.myanimelibrary.infrastructure.entities.UserEntity;
import com.example.myanimelibrary.infrastructure.exception.ResourceNotFoundException;
import com.example.myanimelibrary.infrastructure.jparepositories.JPAUserRepository;
import com.example.myanimelibrary.infrastructure.mapper.UserMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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
    public User getUserByUsername(String login) {
        UserEntity userEntityFound = jpaUserRepository.findByLogin(login);
        if (userEntityFound == null) {
            throw new ResourceNotFoundException("User not found");
        }
        return userMapper.fromEntityToModel(userEntityFound);
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> userEntitiesFound = jpaUserRepository.findAll();
        return userEntitiesFound.stream().map(userMapper::fromEntityToModel).collect(Collectors.toList());
    }
}
