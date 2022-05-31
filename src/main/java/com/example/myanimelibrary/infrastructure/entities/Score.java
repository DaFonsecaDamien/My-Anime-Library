package com.example.myanimelibrary.infrastructure.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Score {

    @Id
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

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
