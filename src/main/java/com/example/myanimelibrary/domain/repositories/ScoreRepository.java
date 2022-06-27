package com.example.myanimelibrary.domain.repositories;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.Score;
import com.example.myanimelibrary.infrastructure.entities.ScoreEntity;

import java.util.List;

public interface ScoreRepository {

    List<Score> saveScoreGenerated(List<Score> scores);

    List<Score> getAllScoreFromAnime(Anime anime);
    Score getScoreByValueAndEntity(Integer value, Anime anime);

    void saveScore(Score score);
}
