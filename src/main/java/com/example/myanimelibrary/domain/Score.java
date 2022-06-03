package com.example.myanimelibrary.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Score {

    private String id;
    private Integer value;
    private Integer nbVotes;
    private float percent;

    public Score(String id, Integer value, Integer nbVotes, float percent) {
        this.id = id;
        this.value = value;
        this.nbVotes = nbVotes;
        this.percent = percent;
    }

    public Score() {

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static List<Score> generateDefaultScoreList(){
        List<Score> scoreList = new ArrayList<>();
        for( int i = 0; i < 11; i++){
            Score score = new Score(
                    UUID.randomUUID().toString(),
                    i,
                    0,
                    0
            );
            scoreList.add(score);
        }
        return scoreList;
    }
}
