package com.example.myanimelibrary.infrastructure.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class UserMangaReview implements Serializable {

    @ManyToOne
    @Id
    private Manga manga;
    @ManyToOne
    @Id
    private UserEntity userEntity;
    private Integer currentChapter;
    private Integer score;
    private String comment;
    private String readSiteUri;

    public UserMangaReview(Manga manga, UserEntity userEntity, Integer currentChapter, Integer score, String comment, String readSiteUri) {
        this.manga = manga;
        this.userEntity = userEntity;
        this.currentChapter = currentChapter;
        this.score = score;
        this.comment = comment;
        this.readSiteUri = readSiteUri;
    }

    public UserMangaReview() {

    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public UserEntity getUser() {
        return userEntity;
    }

    public void setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
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
        return Objects.equals(manga, that.manga) && Objects.equals(userEntity, that.userEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manga, userEntity);
    }
}
