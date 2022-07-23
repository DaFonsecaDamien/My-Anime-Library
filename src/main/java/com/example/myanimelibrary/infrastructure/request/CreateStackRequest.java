package com.example.myanimelibrary.infrastructure.request;

import com.example.myanimelibrary.domain.StackVisibility;

public class CreateStackRequest {

    private String name;
    private StackVisibility visibility;
    private Long userId;

    public CreateStackRequest(String name, StackVisibility visibility, Long userId) {
        this.name = name;
        this.visibility = visibility;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
