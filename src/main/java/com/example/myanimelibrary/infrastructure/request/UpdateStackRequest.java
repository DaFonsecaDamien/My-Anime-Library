package com.example.myanimelibrary.infrastructure.request;

import com.example.myanimelibrary.domain.StackVisibility;

public class UpdateStackRequest {

    private Long stackId;
    private String name;
    private StackVisibility visibility;

    public UpdateStackRequest() {
    }

    public UpdateStackRequest(Long stackId, String name, StackVisibility visibility) {
        this.stackId = stackId;
        this.name = name;
        this.visibility = visibility;
    }

    public Long getStackId() {
        return stackId;
    }

    public void setStackId(Long stackId) {
        this.stackId = stackId;
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
}
