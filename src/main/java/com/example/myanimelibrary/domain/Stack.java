package com.example.myanimelibrary.domain;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    private String id;
    private String name;
    private List<Manga> mangas;
    private List<Anime> animes;
    private StackVisibility visibility;

    public Stack(String id, String name, List<Manga> mangas, List<Anime> animes, StackVisibility visibility) {
        this.id = id;
        this.name = name;
        this.mangas = mangas;
        this.animes = animes;
        this.visibility = visibility;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMangas(List<Manga> mangas) {
        this.mangas = mangas;
    }

    public void setAnimes(List<Anime> animes) {
        this.animes = animes;
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

    public List<Manga> getMangas() {
        return mangas;
    }

    public List<Anime> getAnimes() {
        return animes;
    }

    public StackVisibility getVisibility() {
        return visibility;
    }
}
