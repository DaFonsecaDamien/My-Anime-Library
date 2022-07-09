package com.example.myanimelibrary.domain;

public class StackManga {

    private Long id;
    private Manga manga;
    private Stack stack;

    public StackManga(Long id, Manga manga, Stack stack) {
        this.id = id;
        this.manga = manga;
        this.stack = stack;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }
}
