package com.example.myanimelibrary.domain;

import java.util.ArrayList;

public class UserLibrary {

    private User user;
    private Library userLibrary;

    public UserLibrary(User user, Library userLibrary) {
        this.user = user;
        this.userLibrary = userLibrary;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserLibrary(Library userLibrary) {
        this.userLibrary = userLibrary;
    }

    public User getUser() {
        return user;
    }

    public Library getUserLibrary() {
        return userLibrary;
    }
}
