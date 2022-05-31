package com.example.myanimelibrary.infrastructure.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Library implements Serializable {

    @Id
    private String id;
    @OneToOne
    private User user;
    @OneToMany
    private List<Stack> stacks;


    public Library(String id, ArrayList<Stack> categories) {
        this.id = id;
        this.stacks = categories;
    }

    public Library() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStacks(ArrayList<Stack> stacks) {
        this.stacks = stacks;
    }

    public String getId() {
        return id;
    }

    public List<Stack> getStacks() {
        return stacks;
    }

}
