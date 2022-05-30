package com.example.myanimelibrary.domain;

import java.util.ArrayList;

public class Category {

    private String id;
    private String name;
    private ArrayList<UserManga> userMangas;
    private ArrayList<UserAnime> userAnimes;
    private CategoryVisibility visibility;

    public Category(String id, String name, ArrayList<UserManga> userMangas, ArrayList<UserAnime> userAnimes, CategoryVisibility visibility) {
        this.id = id;
        this.name = name;
        this.userMangas = userMangas;
        this.userAnimes = userAnimes;
        this.visibility = visibility;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserMangas(ArrayList<UserManga> userMangas) {
        this.userMangas = userMangas;
    }

    public void setUserAnimes(ArrayList<UserAnime> userAnimes) {
        this.userAnimes = userAnimes;
    }

    public void setVisibility(CategoryVisibility visibility) {
        this.visibility = visibility;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<UserManga> getUserMangas() {
        return userMangas;
    }

    public ArrayList<UserAnime> getUserAnimes() {
        return userAnimes;
    }

    public CategoryVisibility getVisibility() {
        return visibility;
    }
}
