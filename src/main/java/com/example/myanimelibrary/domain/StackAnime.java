package com.example.myanimelibrary.domain;

public class StackAnime {

    private Long id;
    private Anime anime;
    private Stack stack;

    public StackAnime() {
    }

    public StackAnime(Long id, Anime anime, Stack stack) {
        this.id = id;
        this.anime = anime;
        this.stack = stack;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }
}
