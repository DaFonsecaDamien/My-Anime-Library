package com.example.myanimelibrary.infrastructure.jparepositories;

import com.example.myanimelibrary.infrastructure.entities.AnimeEntity;
import com.example.myanimelibrary.infrastructure.entities.UserAnimeReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAUserAnimeReviewRepository extends JpaRepository<UserAnimeReviewEntity, Long> {

    //    public void
    UserAnimeReviewEntity getById(Long id);


    List<UserAnimeReviewEntity> getAllByAnimeEntity(AnimeEntity Anime);

    void deleteById(Long id);

    List<UserAnimeReviewEntity> getAllByUserEntityId(Long userId);
}
