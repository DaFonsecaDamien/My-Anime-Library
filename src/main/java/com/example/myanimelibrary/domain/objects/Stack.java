package com.example.myanimelibrary.domain.objects;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    private String id;
    private String name;
    private List<UserMangaReview> userMangasReviews;
    private List<UserAnimeReview> userAnimeReviews;
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

    public List<UserAnimeReview> getUserAnimes() {
        return userAnimeReviews;
    }

    public void setUserAnimes(ArrayList<UserAnimeReview> userAnimeReviews) {
        this.userAnimeReviews = userAnimeReviews;
    }

    public StackVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(StackVisibility visibility) {
        this.visibility = visibility;
    }
}
