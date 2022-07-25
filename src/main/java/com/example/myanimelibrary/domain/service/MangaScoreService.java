package com.example.myanimelibrary.domain.service;

import com.example.myanimelibrary.domain.Manga;
import com.example.myanimelibrary.domain.MangaScore;
import com.example.myanimelibrary.domain.repositories.MangaScoreRepository;

import java.util.List;

public class MangaScoreService {
    private final MangaScoreRepository scoreRepository;

    public MangaScoreService(MangaScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public List<MangaScore> getAllscoreFromManga(Manga manga) {
        return scoreRepository.getAllScoreFromManga(manga);
    }

    public MangaScore getScoreByMangaAndValue(Integer value, Manga manga) {
        return scoreRepository.getScoreByValueAndEntity(value, manga);
    }

    public void saveScore(MangaScore score) {
        scoreRepository.saveScore(score);
    }
}
