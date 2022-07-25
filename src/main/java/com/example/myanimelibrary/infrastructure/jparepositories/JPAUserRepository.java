package com.example.myanimelibrary.infrastructure.jparepositories;

import com.example.myanimelibrary.domain.User;
import com.example.myanimelibrary.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAUserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);

}
