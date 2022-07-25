package com.example.myanimelibrary.infrastructure.request;

import com.example.myanimelibrary.domain.Manga;
import com.example.myanimelibrary.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateUserMangaReviewRequest {
    private Manga manga;
    private User user;
    private Integer currentChapter;
    private Integer score;
    private String comment;
    private String mangaSiteUri;

    @Autowired
    public CreateUserMangaReviewRequest(Manga manga, User user, Integer currentChapter, Integer score, String comment, String mangaSiteUri) {
        this.manga = manga;
        this.user = user;
        this.currentChapter = currentChapter;
        this.score = score;
        this.comment = comment;
        this.mangaSiteUri = mangaSiteUri;
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

    public String getMangaSiteUri() {
        return mangaSiteUri;
    }

    public void setMangaSiteUri(String mangaSiteUri) {
        this.mangaSiteUri = mangaSiteUri;
    }
}
