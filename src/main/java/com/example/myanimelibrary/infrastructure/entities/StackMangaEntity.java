package com.example.myanimelibrary.infrastructure.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class StackMangaEntity {

    @Id
    private Long id;
    @ManyToOne
    private MangaEntity mangaEntity;

    public StackMangaEntity() {
    }

    public StackMangaEntity(Long id, MangaEntity mangaEntity) {
        this.id = id;
        this.mangaEntity = mangaEntity;
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
}
