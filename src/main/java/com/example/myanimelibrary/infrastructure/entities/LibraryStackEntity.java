package com.example.myanimelibrary.infrastructure.entities;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class LibraryStackEntity {

    @Id
    private LibraryEntity libraryEntity;
    @Id
    @ManyToOne
    private StackEntity stack;

    public LibraryStackEntity() {
    }

    public LibraryStackEntity(LibraryEntity libraryEntity, StackEntity stack) {
        this.libraryEntity = libraryEntity;
        this.stack = stack;
    }

    public LibraryEntity getLibraryEntity() {
        return libraryEntity;
    }

    public void setLibraryEntity(LibraryEntity libraryEntity) {
        this.libraryEntity = libraryEntity;
    }

    public StackEntity getStack() {
        return stack;
    }

    public void setStack(StackEntity stack) {
        this.stack = stack;
    }
}
