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

    public Anime(String id, Map<String, String> titles, String imageUrl, Integer year, Integer episodes, String durationPerEpisodes, String studio, String synopsys, String type, AnimeState state, List<String> genre, List<Score> scores, float averageScore, Integer nbVotes, Integer ranking) {
        this.id = id;
        this.titles = titles;
        this.imageUrl = imageUrl;
        this.year = year;
        this.episodes = episodes;
        this.durationPerEpisodes = durationPerEpisodes;
        this.studio = studio;
        this.synopsys = synopsys;
        this.type = type;
        this.state = state;
        this.genre = genre;
        this.scores = scores;
        this.averageScore = averageScore;
        this.nbVotes = nbVotes;
        this.ranking = ranking;
    }

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
