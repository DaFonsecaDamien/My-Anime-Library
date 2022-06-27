package com.example.myanimelibrary.infrastructure.jparepositories;

import com.example.myanimelibrary.infrastructure.entities.AnimeEntity;
import com.example.myanimelibrary.infrastructure.entities.UserAnimeReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAUserAnimeReviewRepository extends JpaRepository<UserAnimeReviewEntity, String> {

//    public void
    UserAnimeReviewEntity getById(String id);

    List<UserAnimeReviewEntity> getAllByAnimeEntity(AnimeEntity Anime);

    void deleteById(String id);
}
