package com.example.myanimelibrary.domain;

import java.util.ArrayList;
import java.util.List;

public class MangaScore {
    private Long id;
    private Integer value;
    private Integer nbVotes;
    private float percent;

    private Manga manga;

    public MangaScore(Long id, Integer value, Integer nbVotes, float percent, Manga manga) {
        this.id = id;
        this.value = value;
        this.nbVotes = nbVotes;
        this.percent = percent;
        this.manga = manga;
    }

    public static List<MangaScore> generateDefaultScoreList(Manga manga) {
        List<MangaScore> scoreList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            MangaScore score = new MangaScore(
                    null,
                    i,
                    0,
                    0,
                    manga
            );
            scoreList.add(score);
        }
        return scoreList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getNbVotes() {
        return nbVotes;
    }

    public void setNbVotes(Integer nbVotes) {
        this.nbVotes = nbVotes;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

}
