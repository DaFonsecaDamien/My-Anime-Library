package com.example.myanimelibrary.domain.service;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.Score;
import com.example.myanimelibrary.domain.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public List<Score> getAllscoreFromAnime(Anime anime){
        return scoreRepository.getAllScoreFromAnime(anime);
    }

    public Score getScoreByAnimeAndValue(Integer value, Anime anime){
        return scoreRepository.getScoreByValueAndEntity(value, anime);
    }

    public void saveScore(Score score){
        scoreRepository.saveScore(score);
    }


}
