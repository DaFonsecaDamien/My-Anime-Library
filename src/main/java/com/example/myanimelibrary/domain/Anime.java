package com.example.myanimelibrary.domain;

import java.util.List;
import java.util.Map;

public class Anime {

    private String id;
    private Map<String, String> titles;
    private String imageUrl;
    private Integer year;
    private Integer episodes;
    private String durationPerEpisodes;
    private String studio;
    private String synopsys;
    private String type;
    private AnimeState state;
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
