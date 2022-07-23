package com.example.myanimelibrary.infrastructure.request;

public class UpdateUserAnimeReviewRequest {

    private Integer currentEpisode;
    private Integer score;
    private String comment;
    private String animeSiteUri;

    public UpdateUserAnimeReviewRequest(Integer currentEpisode, Integer score, String comment, String animeSiteUri) {
        this.currentEpisode = currentEpisode;
        this.score = score;
        this.comment = comment;
        this.animeSiteUri = animeSiteUri;
    }

    public Integer getCurrentEpisode() {
        return currentEpisode;
    }

    public Integer getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public String getAnimeSiteUri() {
        return animeSiteUri;
    }
}
