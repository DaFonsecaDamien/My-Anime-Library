package com.example.myanimelibrary.infrastructure.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class UserMangaReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private MangaEntity mangaEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;
    private Integer currentChapter;
    private Integer score;
    private String comment;
    private String mangaSiteUri;

    public UserMangaReviewEntity(MangaEntity mangaEntity, UserEntity userEntity, Integer currentChapter, Integer score, String comment, String mangaSiteUri) {
        this.mangaEntity = mangaEntity;
        this.userEntity = userEntity;
        this.currentChapter = currentChapter;
        this.score = score;
        this.comment = comment;
        this.mangaSiteUri = mangaSiteUri;
    }

    public UserMangaReviewEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MangaEntity getMangaEntity() {
        return mangaEntity;
    }

    public void setMangaEntity(MangaEntity mangaEntity) {
        this.mangaEntity = mangaEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
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

    public String getMangaSiteUri() {
        return mangaSiteUri;
    }

    public void setMangaSiteUri(String readSiteUri) {
        this.mangaSiteUri = readSiteUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMangaReviewEntity that = (UserMangaReviewEntity) o;
        return Objects.equals(mangaEntity, that.mangaEntity) && Objects.equals(userEntity, that.userEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mangaEntity, userEntity);
    }
}
