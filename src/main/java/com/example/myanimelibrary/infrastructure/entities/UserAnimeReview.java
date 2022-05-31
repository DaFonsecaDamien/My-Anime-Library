package com.example.myanimelibrary.infrastructure.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class UserAnimeReview implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @Id
    private Anime manga;
    @ManyToOne(fetch = FetchType.EAGER)
    @Id
    private User user;
    private Integer currentEpisode;
    private Integer score;
    private String comment;
    private String animeSiteUri;

    public UserAnimeReview(Anime manga, User user, Integer currentEpisode, Integer score, String comment, String animeSiteUri) {
        this.manga = manga;
        this.user = user;
        this.currentEpisode = currentEpisode;
        this.score = score;
        this.comment = comment;
        this.animeSiteUri = animeSiteUri;
    }

    public UserAnimeReview() {

    }

    public void setManga(Anime manga) {
        this.manga = manga;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Anime getManga() {
        return manga;
    }

    public User getUser() {
        return user;
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
        UserAnimeReview that = (UserAnimeReview) o;
        return Objects.equals(manga.getId(), that.manga.getId()) && Objects.equals(user.getId(), that.user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(manga.getId(), user.getId());
    }
}
