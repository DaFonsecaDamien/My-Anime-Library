package com.example.myanimelibrary.domain;

public class Score {

    private Integer value;
    private Integer nbVotes;
    private float percent;

    public Score(Integer value, Integer nbVotes, float percent) {
        this.value = value;
        this.nbVotes = nbVotes;
        this.percent = percent;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setNbVotes(Integer nbVotes) {
        this.nbVotes = nbVotes;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getNbVotes() {
        return nbVotes;
    }

    public float getPercent() {
        return percent;
    }
}
