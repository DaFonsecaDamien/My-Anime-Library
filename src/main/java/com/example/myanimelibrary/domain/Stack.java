package com.example.myanimelibrary.domain;

import java.util.List;

public class Stack {

    private Long id;
    private String name;
    private List<Manga> mangas;
    private List<Anime> animes;
    private StackVisibility visibility;
    private Library library;

    public Stack() {
    }

    public Stack(Long id, String name, List<Manga> mangas, List<Anime> animes, StackVisibility visibility, Library library) {
        this.id = id;
        this.name = name;
        this.mangas = mangas;
        this.animes = animes;
        this.visibility = visibility;
        this.library = library;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Manga> getMangas() {
        return mangas;
    }

    public void setMangas(List<Manga> mangas) {
        this.mangas = mangas;
    }

    public List<Anime> getAnimes() {
        return animes;
    }

    public void setAnimes(List<Anime> animes) {
        this.animes = animes;
    }

    public StackVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(StackVisibility visibility) {
        this.visibility = visibility;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
