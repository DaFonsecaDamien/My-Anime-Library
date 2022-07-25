package com.example.myanimelibrary.infrastructure.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class MangaScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private MangaEntity mangaEntity;
    private Integer value;
    private Integer nbVotes;
    private float percent;

    public MangaScoreEntity() {

    }

    public MangaScoreEntity(Long id, MangaEntity mangaEntity, Integer value, Integer nbVotes, float percent) {
        this.id = id;
        this.mangaEntity = mangaEntity;
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

    public MangaEntity getMangaEntity() {
        return mangaEntity;
    }

    public void setMangaEntity(MangaEntity mangaEntity) {
        this.mangaEntity = mangaEntity;
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
        return "MangaScoreEntity{" +
                "id='" + id + '\'' +
                ", mangaEntity=" + mangaEntity +
                ", value=" + value +
                ", nbVotes=" + nbVotes +
                ", percent=" + percent +
                "} + id manga =  " + mangaEntity.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MangaScoreEntity that = (MangaScoreEntity) o;
        return Objects.equals(mangaEntity.getId(), that.mangaEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(mangaEntity.getId());
    }
}
