package com.example.myanimelibrary.domain;

import java.util.ArrayList;
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
    private ArrayList<String> genre;
    private ArrayList<Score> scores;
    private float averageScore;
    private Integer nbVotes;
    private Integer rank;

    public Anime(String id, Map<String, String> titles, String imageUrl, Integer year, Integer episodes, String durationPerEpisodes, String studio, String synopsys, String type, AnimeState state, ArrayList<String> genre, ArrayList<Score> scores, float averageScore, Integer nbVotes, Integer rank) {
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
        this.rank = rank;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitles(Map<String, String> titles) {
        this.titles = titles;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public void setDurationPerEpisodes(String durationPerEpisodes) {
        this.durationPerEpisodes = durationPerEpisodes;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setSynopsys(String synopsys) {
        this.synopsys = synopsys;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setState(AnimeState state) {
        this.state = state;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public void setScores(ArrayList<Score> scores) {
        this.scores = scores;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }

    public void setNbVotes(Integer nbVotes) {
        this.nbVotes = nbVotes;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public Map<String, String> getTitles() {
        return titles;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public String getDurationPerEpisodes() {
        return durationPerEpisodes;
    }

    public String getStudio() {
        return studio;
    }

    public String getSynopsys() {
        return synopsys;
    }

    public String getType() {
        return type;
    }

    public AnimeState getState() {
        return state;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public ArrayList<Score> getScores() {
        return scores;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public Integer getNbVotes() {
        return nbVotes;
    }

    public Integer getRank() {
        return rank;
    }
}
