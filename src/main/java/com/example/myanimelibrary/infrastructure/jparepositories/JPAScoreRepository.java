package com.example.myanimelibrary.infrastructure.jparepositories;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.infrastructure.entities.AnimeEntity;
import com.example.myanimelibrary.infrastructure.entities.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPAScoreRepository extends JpaRepository<ScoreEntity, String> {

    ScoreEntity getByAnimeEntityAndValue(AnimeEntity animeEntity, Integer value);

    List<ScoreEntity> getAllByAnimeEntity(AnimeEntity animeEntity);
}
