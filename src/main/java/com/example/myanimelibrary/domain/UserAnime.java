package com.example.myanimelibrary.domain;

public class UserAnime {

    private Anime manga;
    private User user;
    private Integer currentEpisode;
    private Integer score;
    private String comment;
    private String animeSiteUri;

    public UserAnime(Anime manga, User user, Integer currentEpisode, Integer score, String comment, String animeSiteUri) {
        this.manga = manga;
        this.user = user;
        this.currentEpisode = currentEpisode;
        this.score = score;
        this.comment = comment;
        this.animeSiteUri = animeSiteUri;
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
}
