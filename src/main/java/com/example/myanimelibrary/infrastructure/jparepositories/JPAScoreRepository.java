package com.example.myanimelibrary.infrastructure.jparepositories;

import com.example.myanimelibrary.infrastructure.entities.AnimeEntity;
import com.example.myanimelibrary.infrastructure.entities.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAScoreRepository extends JpaRepository<ScoreEntity, Long> {

    ScoreEntity getByAnimeEntityAndValue(AnimeEntity animeEntity, Integer value);

    List<ScoreEntity> getAllByAnimeEntity(AnimeEntity animeEntity);
}
