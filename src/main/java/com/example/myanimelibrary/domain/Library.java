package com.example.myanimelibrary.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable {

    private String id;
    private User user;
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
