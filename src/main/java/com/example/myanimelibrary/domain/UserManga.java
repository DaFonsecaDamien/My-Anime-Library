package com.example.myanimelibrary.domain;

public class UserManga {

    private Manga manga;
    private User user;
    private Integer currentChapter;
    private Integer score;
    private String comment;
    private String readSiteUri;

    public UserManga(Manga manga, User user, Integer currentChapter, Integer score, String comment, String readSiteUri) {
        this.manga = manga;
        this.user = user;
        this.currentChapter = currentChapter;
        this.score = score;
        this.comment = comment;
        this.readSiteUri = readSiteUri;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCurrentChapter(Integer currentChapter) {
        this.currentChapter = currentChapter;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setReadSiteUri(String readSiteUri) {
        this.readSiteUri = readSiteUri;
    }

    public Manga getManga() {
        return manga;
    }

    public User getUser() {
        return user;
    }

    public Integer getCurrentChapter() {
        return currentChapter;
    }

    public Integer getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public String getReadSiteUri() {
        return readSiteUri;
    }
}
