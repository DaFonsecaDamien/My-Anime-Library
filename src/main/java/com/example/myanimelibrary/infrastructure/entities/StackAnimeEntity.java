package com.example.myanimelibrary.infrastructure.entities;

import javax.persistence.*;

@Entity
@Table
public class StackAnimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private StackEntity stackEntity;
    @ManyToOne
    private AnimeEntity animeEntity;

    public StackAnimeEntity() {
    }

    public StackAnimeEntity(Long id, StackEntity stackEntity, AnimeEntity animeEntity) {
        this.id = id;
        this.stackEntity = stackEntity;
        this.animeEntity = animeEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StackEntity getStackEntity() {
        return stackEntity;
    }

    public void setStackEntity(StackEntity stackEntity) {
        this.stackEntity = stackEntity;
    }

    public AnimeEntity getAnimeEntity() {
        return animeEntity;
    }

    public void setAnimeEntity(AnimeEntity animeEntity) {
        this.animeEntity = animeEntity;
    }
}
