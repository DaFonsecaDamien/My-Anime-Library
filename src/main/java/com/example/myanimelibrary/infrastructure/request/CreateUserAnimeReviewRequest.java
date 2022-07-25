package com.example.myanimelibrary.infrastructure.request;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateUserAnimeReviewRequest {

    private Anime anime;
    private User user;
    private Integer currentEpisode;
    private Integer score;
    private String comment;
    private String animeSiteUri;

    @Autowired
    public CreateUserAnimeReviewRequest(Anime anime, User user, Integer currentEpisode, Integer score, String comment, String animeSiteUri) {
        this.anime = anime;
        this.user = user;
        this.currentEpisode = currentEpisode;
        this.score = score;
        this.comment = comment;
        this.animeSiteUri = animeSiteUri;
    }

    public CreateUserAnimeReviewRequest() {
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
}
