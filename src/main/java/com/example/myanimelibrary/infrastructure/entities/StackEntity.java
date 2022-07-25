package com.example.myanimelibrary.infrastructure.entities;

import com.example.myanimelibrary.domain.StackVisibility;

import javax.persistence.*;

@Entity
@Table
public class StackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private StackVisibility visibility;
    @ManyToOne
    private LibraryEntity library;

    public StackEntity() {

    }

    public StackEntity(Long id, String name, StackVisibility visibility, LibraryEntity library) {
        this.id = id;
        this.name = name;
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

    public StackVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(StackVisibility visibility) {
        this.visibility = visibility;
    }

    public LibraryEntity getLibrary() {
        return library;
    }

    public void setLibrary(LibraryEntity library) {
        this.library = library;
    }
}
