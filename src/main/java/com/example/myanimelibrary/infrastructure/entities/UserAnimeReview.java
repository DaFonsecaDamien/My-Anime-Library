package com.example.myanimelibrary.infrastructure.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class UserAnimeReview implements Serializable {

    @ManyToOne
    @Id
    private AnimeEntity animeEntity;
    @ManyToOne
    @Id
    private User user;
    private Integer currentEpisode;
    private Integer score;
    private String comment;
    private String animeSiteUri;

    public UserAnimeReview(AnimeEntity animeEntity, User user, Integer currentEpisode, Integer score, String comment, String animeSiteUri) {
        this.animeEntity = animeEntity;
        this.user = user;
        this.currentEpisode = currentEpisode;
        this.score = score;
        this.comment = comment;
        this.animeSiteUri = animeSiteUri;
    }

    public UserAnimeReview() {

    }

    public AnimeEntity getAnime() {
        return animeEntity;
    }

    public void setAnime(AnimeEntity animeEntity) {
        this.animeEntity = animeEntity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCurrentEpisode() {
        return currentEpisode;
    }

    public void setCurrentEpisode(Integer currentEpisode) {
        this.currentEpisode = currentEpisode;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAnimeSiteUri() {
        return animeSiteUri;
    }

    public void setAnimeSiteUri(String animeSiteUri) {
        this.animeSiteUri = animeSiteUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAnimeReview that = (UserAnimeReview) o;
        return Objects.equals(animeEntity.getId(), that.animeEntity.getId()) && Objects.equals(user.getId(), that.user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(animeEntity.getId(), user.getId());
    }
}
