package com.example.myanimelibrary.domain;

import java.io.Serializable;
import java.util.Objects;

public class UserMangaReview implements Serializable {

    private Long id;
    private Manga manga;
    private User user;
    private Integer currentChapter;
    private Integer score;
    private String comment;
    private String readSiteUri;

    public UserMangaReview(Long id, Manga manga, User user, Integer currentChapter, Integer score, String comment, String readSiteUri) {
        this.manga = manga;
        this.user = user;
        this.currentChapter = currentChapter;
        this.score = score;
        this.comment = comment;
        this.readSiteUri = readSiteUri;
    }

    public UserMangaReview() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCurrentChapter() {
        return currentChapter;
    }

    public void setCurrentChapter(Integer currentChapter) {
        this.currentChapter = currentChapter;
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

    public String getReadSiteUri() {
        return readSiteUri;
    }

    public void setReadSiteUri(String readSiteUri) {
        this.readSiteUri = readSiteUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMangaReview that = (UserMangaReview) o;
        return Objects.equals(manga.getId(), that.manga.getId()) && Objects.equals(user.getId(), that.user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(manga.getId(), user.getId());
    }
}
