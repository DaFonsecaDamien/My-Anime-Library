package com.example.myanimelibrary.domain;

import java.io.Serializable;
import java.util.List;

public class Library implements Serializable {

    private Long id;
    private User user;
    private List<Stack> stacks;


    public Library(Long id, User user, List<Stack> stacks) {
        this.id = id;
        this.user = user;
        this.stacks = stacks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Stack> getStacks() {
        return stacks;
    }

    public void setStacks(List<Stack> stacks) {
        this.stacks = stacks;
    }
}
