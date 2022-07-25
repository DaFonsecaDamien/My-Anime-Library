package com.example.myanimelibrary.infrastructure.request;

public class AddAnimeToStackRequest {

    private Long stackId;
    private Long animeId;

    public AddAnimeToStackRequest(Long stackId, Long animeId) {
        this.stackId = stackId;
        this.animeId = animeId;
    }

    public Long getStackId() {
        return stackId;
    }

    public void setStackId(Long stackId) {
        this.stackId = stackId;
    }

    public Long getAnimeId() {
        return animeId;
    }

    public void setAnimeId(Long animeId) {
        this.animeId = animeId;
    }
}
