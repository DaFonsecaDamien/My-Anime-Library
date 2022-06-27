package com.example.myanimelibrary.infrastructure.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Stack {

    @Id
    private String id;
    private String name;
    @OneToMany
    private List<UserMangaReview> userMangasReviews;
    @OneToMany
    private List<UserAnimeReviewEntity> userAnimeReviewEntities;
    @Enumerated(EnumType.ORDINAL)
    private StackVisibility visibility;

    public Stack(String id, String name, ArrayList<UserMangaReview> userMangasReviews, ArrayList<UserAnimeReviewEntity> userAnimeReviewEntities, StackVisibility visibility) {
        this.id = id;
        this.name = name;
        this.userMangasReviews = userMangasReviews;
        this.userAnimeReviewEntities = userAnimeReviewEntities;
        this.visibility = visibility;
    }

    public Stack() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserMangaReview> getUserMangas() {
        return userMangasReviews;
    }

    public void setUserMangas(ArrayList<UserMangaReview> userMangasReviews) {
        this.userMangasReviews = userMangasReviews;
    }

    public List<UserAnimeReviewEntity> getUserAnimes() {
        return userAnimeReviewEntities;
    }

    public void setUserAnimes(ArrayList<UserAnimeReviewEntity> userAnimeReviewEntities) {
        this.userAnimeReviewEntities = userAnimeReviewEntities;
    }

    public StackVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(StackVisibility visibility) {
        this.visibility = visibility;
    }
}
