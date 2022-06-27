package com.example.myanimelibrary.infrastructure.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class ScoreEntity {

    @Id
    private String id;
    @ManyToOne
    private AnimeEntity animeEntity;
    private Integer value;
    private Integer nbVotes;
    private float percent;

    public ScoreEntity() {

    }

    public ScoreEntity(String id, Integer value, Integer nbVotes, float percent, AnimeEntity animeEntity) {
        this.id = id;
        this.value = value;
        this.nbVotes = nbVotes;
        this.percent = percent;
        this.animeEntity = animeEntity;
    }

    public void setAnime(AnimeEntity animeEntity) {
        this.animeEntity = animeEntity;
    }

    public AnimeEntity getAnime() {
        return animeEntity;
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

    @Override
    public String toString() {
        return "ScoreEntity{" +
                "id='" + id + '\'' +
                ", animeEntity=" + animeEntity +
                ", value=" + value +
                ", nbVotes=" + nbVotes +
                ", percent=" + percent +
                "} + id anime =  " + animeEntity.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreEntity that = (ScoreEntity) o;
        return Objects.equals(animeEntity.getId(), that.animeEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(animeEntity.getId());
    }
}
