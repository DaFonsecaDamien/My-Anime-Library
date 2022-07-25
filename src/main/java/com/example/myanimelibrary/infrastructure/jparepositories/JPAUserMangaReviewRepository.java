package com.example.myanimelibrary.infrastructure.jparepositories;

import com.example.myanimelibrary.infrastructure.entities.MangaEntity;
import com.example.myanimelibrary.infrastructure.entities.UserMangaReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPAUserMangaReviewRepository extends JpaRepository<UserMangaReviewEntity, Long> {
    UserMangaReviewEntity getById(Long id);


    List<UserMangaReviewEntity> getAllByMangaEntity(MangaEntity mangaEntity);

    void deleteById(Long id);

    List<UserMangaReviewEntity> getAllByUserEntityId(Long userId);
}
