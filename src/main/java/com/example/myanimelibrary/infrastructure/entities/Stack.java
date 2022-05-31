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
    private List<UserAnimeReview> userAnimeReviews;
    @Enumerated(EnumType.ORDINAL)
    private StackVisibility visibility;

    public Stack(String id, String name, ArrayList<UserMangaReview> userMangasReviews, ArrayList<UserAnimeReview> userAnimeReviews, StackVisibility visibility) {
        this.id = id;
        this.name = name;
        this.userMangasReviews = userMangasReviews;
        this.userAnimeReviews = userAnimeReviews;
        this.visibility = visibility;
    }

    public Stack() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserMangas(ArrayList<UserMangaReview> userMangasReviews) {
        this.userMangasReviews = userMangasReviews;
    }

    public void setUserAnimes(ArrayList<UserAnimeReview> userAnimeReviews) {
        this.userAnimeReviews = userAnimeReviews;
    }

    public void setVisibility(StackVisibility visibility) {
        this.visibility = visibility;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<UserMangaReview> getUserMangas() {
        return userMangasReviews;
    }

    public List<UserAnimeReview> getUserAnimes() {
        return userAnimeReviews;
    }

    public StackVisibility getVisibility() {
        return visibility;
    }
}
