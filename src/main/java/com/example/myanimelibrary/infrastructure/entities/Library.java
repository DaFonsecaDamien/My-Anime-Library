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
    private UserEntity userEntity;
    @OneToMany
    private List<Stack> stacks;


    public Library(String id, ArrayList<Stack> categories) {
        this.id = id;
        this.stacks = categories;
    }

    public Library() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Stack> getStacks() {
        return stacks;
    }

    public void setStacks(ArrayList<Stack> stacks) {
        this.stacks = stacks;
    }

}
