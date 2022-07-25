package com.example.myanimelibrary.domain.repositories;

import com.example.myanimelibrary.domain.Manga;
import com.example.myanimelibrary.domain.MangaScore;

import java.util.List;

public interface MangaScoreRepository {
    List<MangaScore> saveScoreGenerated(List<MangaScore> scores);

    List<MangaScore> getAllScoreFromManga(Manga manga);

    MangaScore getScoreByValueAndEntity(Integer value, Manga manga);

    void saveScore(MangaScore score);
}
