package com.example.myanimelibrary.domain;

import java.util.ArrayList;

public class Library {

    private String id;

    private ArrayList<Stack> stacks;


    public Library(String id, ArrayList<Stack> categories) {
        this.id = id;
        this.stacks = categories;
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

    public ArrayList<Stack> getStacks() {
        return stacks;
    }
}
