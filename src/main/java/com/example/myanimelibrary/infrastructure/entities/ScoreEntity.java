package com.example.myanimelibrary.infrastructure.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class ScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private AnimeEntity animeEntity;
    private Integer value;
    private Integer nbVotes;
    private float percent;

    public ScoreEntity() {

    }

    public ScoreEntity(Long id, AnimeEntity animeEntity, Integer value, Integer nbVotes, float percent) {
        this.id = id;
        this.animeEntity = animeEntity;
        this.value = value;
        this.nbVotes = nbVotes;
        this.percent = percent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnimeEntity getAnimeEntity() {
        return animeEntity;
    }

    public void setAnimeEntity(AnimeEntity animeEntity) {
        this.animeEntity = animeEntity;
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
