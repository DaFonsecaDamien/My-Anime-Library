package com.example.myanimelibrary.infrastructure.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class UserAnimeReviewEntity {

    @Id
    private String id;
    @ManyToOne
    private AnimeEntity animeEntity;
    @ManyToOne
    private UserEntity userEntity;
    private Integer currentEpisode;
    private Integer score;
    private String comment;
    private String animeSiteUri;

    public UserAnimeReviewEntity() {

    }

    public UserAnimeReviewEntity(String id, AnimeEntity animeEntity, UserEntity userEntity, Integer currentEpisode, Integer score, String comment, String animeSiteUri) {
        this.id = id;
        this.animeEntity = animeEntity;
        this.userEntity = userEntity;
        this.currentEpisode = currentEpisode;
        this.score = score;
        this.comment = comment;
        this.animeSiteUri = animeSiteUri;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAnimeEntity(AnimeEntity animeEntity) {
        this.animeEntity = animeEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public void setCurrentEpisode(Integer currentEpisode) {
        this.currentEpisode = currentEpisode;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setAnimeSiteUri(String animeSiteUri) {
        this.animeSiteUri = animeSiteUri;
    }

    public String getId() {
        return id;
    }

    public AnimeEntity getAnimeEntity() {
        return animeEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public Integer getCurrentEpisode() {
        return currentEpisode;
    }

    public Integer getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public String getAnimeSiteUri() {
        return animeSiteUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAnimeReviewEntity that = (UserAnimeReviewEntity) o;
        return Objects.equals(animeEntity.getId(), that.animeEntity.getId()) && Objects.equals(userEntity.getId(), that.userEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(animeEntity.getId(), userEntity.getId());
    }
}
