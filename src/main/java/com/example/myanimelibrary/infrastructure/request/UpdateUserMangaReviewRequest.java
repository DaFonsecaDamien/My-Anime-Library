package com.example.myanimelibrary.infrastructure.request;

public class UpdateUserMangaReviewRequest {

    private Integer currentChapter;
    private Integer score;
    private String comment;
    private String mangaSiteUri;

    public UpdateUserMangaReviewRequest(Integer currentChapter, Integer score, String comment, String mangaSiteUri) {
        this.currentChapter = currentChapter;
        this.score = score;
        this.comment = comment;
        this.mangaSiteUri = mangaSiteUri;
    }

    public Integer getCurrentChapter() {
        return currentChapter;
    }

    public Integer getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public String getMangaSiteUri() {
        return mangaSiteUri;
    }
}
