package com.example.myanimelibrary.TMP.user;

import com.example.myanimelibrary.domain.User;
import com.example.myanimelibrary.infrastructure.entities.UserEntity;

public class Constants {

    public static final User fakeUser = new User(1L, "azerty", "azerty", "azerty");
    public static final UserEntity fakeUserEntity = new UserEntity(1L, "azerty", "azerty", "azerty");
}
