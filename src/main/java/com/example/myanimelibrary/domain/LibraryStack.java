package com.example.myanimelibrary.domain;

public class LibraryStack {

    private Library library;
    private Stack stacks;

    public LibraryStack(Library library, Stack stacks) {
        this.library = library;
        this.stacks = stacks;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Stack getStacks() {
        return stacks;
    }

    public void setStacks(Stack stacks) {
        this.stacks = stacks;
    }
}
