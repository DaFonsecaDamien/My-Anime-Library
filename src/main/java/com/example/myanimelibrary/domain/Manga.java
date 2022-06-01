package com.example.myanimelibrary.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Manga {

    private String id;
    private Map<String, String> titles;
    private String imageUrl;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer chapters;
    private Integer volumes;
    private String author;
    private String synopsys;
    private String type;
    private MangaState state;
    private List<String> genre;
    private List<Score> scores;
    private float averageScore;
    private Integer nbVotes;
    private Integer ranking;

    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
