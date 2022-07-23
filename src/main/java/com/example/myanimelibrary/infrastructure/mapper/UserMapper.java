package com.example.myanimelibrary.infrastructure.mapper;

import com.example.myanimelibrary.domain.User;
import com.example.myanimelibrary.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    User fromEntityToModel(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getLogin(),
                userEntity.getPassword(),
                userEntity.getPseudo()
        );
    }

    UserEntity fromModelToEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getPseudo()
        );
    }
}
