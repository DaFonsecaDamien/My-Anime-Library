package com.example.myanimelibrary.infrastructure.mapper;

import com.example.myanimelibrary.domain.User;
import com.example.myanimelibrary.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User fromEntityToModel(UserEntity userEntity){
        return new User(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getPseudo()
        );
    }

    public UserEntity fromModelToEntity(User user){
        return new UserEntity(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getPseudo()
        );
    }
}
