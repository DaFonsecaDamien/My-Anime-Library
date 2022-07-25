package com.example.myanimelibrary.domain;

import java.util.ArrayList;
import java.util.List;

public class Score {

    private Long id;
    private Integer value;
    private Integer nbVotes;
    private float percent;

    private Anime anime;

    public Score(Long id, Integer value, Integer nbVotes, float percent, Anime anime) {
        this.id = id;
        this.value = value;
        this.nbVotes = nbVotes;
        this.percent = percent;
        this.anime = anime;
    }

    public static List<Score> generateDefaultScoreList(Anime anime){
        if( anime == null){
            return List.of();
        }
        List<Score> scoreList = new ArrayList<>();
        for( int i = 0; i < 11; i++){
            Score score = new Score(
                    null,
                    i,
                    0,
                    0,
                    anime
            );
            scoreList.add(score);
        }
        return scoreList;
    }

    public Score() {
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

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

}
