package com.example.myanimelibrary.domain;

import java.util.ArrayList;

public class LibraryCategories {

    private Library library;
    private ArrayList<Category> categories;

    public LibraryCategories(Library library, ArrayList<Category> categories) {
        this.library = library;
        this.categories = categories;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public Library getLibrary() {
        return library;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }
}
