package com.example.myanimelibrary.domain;

import java.io.Serializable;
import java.util.Objects;

public class UserAnimeReview implements Serializable {

    private Anime anime;
    private User user;
    private Integer currentEpisode;
    private Integer score;
    private String comment;
    private String animeSiteUri;

    public UserAnimeReview(Anime anime, User user, Integer currentEpisode, Integer score, String comment, String animeSiteUri) {
        this.anime = anime;
        this.user = user;
        this.currentEpisode = currentEpisode;
        this.score = score;
        this.comment = comment;
        this.animeSiteUri = animeSiteUri;
    }

    public UserAnimeReview() {

    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
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
        return Objects.equals(anime.getId(), that.anime.getId()) && Objects.equals(user.getId(), that.user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(anime.getId(), user.getId());
    }
}
