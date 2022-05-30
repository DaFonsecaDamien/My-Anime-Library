package com.example.myanimelibrary.domain;

public class MangaUser {

    private UserManga manga;
    private User user;
    private Integer currentChapter;
    private Integer score;
    private String comment;

    public MangaUser(UserManga manga, User user, Integer currentChapter, Integer score, String comment) {
        this.manga = manga;
        this.user = user;
        this.currentChapter = currentChapter;
        this.score = score;
        this.comment = comment;
    }

    public void setManga(UserManga manga) {
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

    public UserManga getManga() {
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
}
