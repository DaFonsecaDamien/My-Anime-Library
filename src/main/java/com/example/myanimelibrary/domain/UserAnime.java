package com.example.myanimelibrary.domain;

public class UserAnime {

    private Anime manga;
    private User user;
    private Integer currentEpisode;
    private Integer score;
    private String comment;

    public UserAnime(Anime manga, User user, Integer currentEpisode, Integer score, String comment) {
        this.manga = manga;
        this.user = user;
        this.currentEpisode = currentEpisode;
        this.score = score;
        this.comment = comment;
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
}
