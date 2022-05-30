package com.example.myanimelibrary.domain;

import java.util.ArrayList;

public class Library {

    private String id;
    private String name;
    private ArrayList<Category> categories;
    private String description;

    public Library(String id, String name, ArrayList<Category> categories, String description) {
        this.id = id;
        this.name = name;
        this.categories = categories;
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public String getDescription() {
        return description;
    }
}
