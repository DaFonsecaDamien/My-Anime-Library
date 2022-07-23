package com.example.myanimelibrary.infrastructure.request;

import com.example.myanimelibrary.domain.StackVisibility;

public class CopyStackRequest {

    private Long srcStackId;
    private String name;
    private StackVisibility visibility;
    private Long userId;
    private Long copyTargetStackId;

    public CopyStackRequest() {
    }

    public CopyStackRequest(Long srcStackId, String name, StackVisibility visibility, Long userId, Long copyTargetStackId) {
        this.srcStackId = srcStackId;
        this.name = name;
        this.visibility = visibility;
        this.userId = userId;
        this.copyTargetStackId = copyTargetStackId;
    }

    public Long getSrcStackId() {
        return srcStackId;
    }

    public void setSrcStackId(Long srcStackId) {
        this.srcStackId = srcStackId;
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

    public Long getCopyTargetStackId() {
        return copyTargetStackId;
    }

    public void setCopyTargetStackId(Long copyTargetStackId) {
        this.copyTargetStackId = copyTargetStackId;
    }
}
