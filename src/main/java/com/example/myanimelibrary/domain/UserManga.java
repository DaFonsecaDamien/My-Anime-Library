package com.example.myanimelibrary.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class UserManga {

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
    private ArrayList<String> genre;
    private ArrayList<Score> scores;
    private Integer rank;

    public UserManga(String id, Map<String, String> titles, String imageUrl, LocalDate startDate, LocalDate endDate, Integer chapters, Integer volumes, String author, String synopsys, String type, MangaState state, ArrayList<String> genre, ArrayList<Score> scores, Integer rank) {
        this.id = id;
        this.titles = titles;
        this.imageUrl = imageUrl;
        this.startDate = startDate;
        this.endDate = endDate;
        this.chapters = chapters;
        this.volumes = volumes;
        this.author = author;
        this.synopsys = synopsys;
        this.type = type;
        this.state = state;
        this.genre = genre;
        this.scores = scores;
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

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setChapters(Integer chapters) {
        this.chapters = chapters;
    }

    public void setVolumes(Integer volumes) {
        this.volumes = volumes;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSynopsys(String synopsys) {
        this.synopsys = synopsys;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setState(MangaState state) {
        this.state = state;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public void setScores(ArrayList<Score> scores) {
        this.scores = scores;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Integer getChapters() {
        return chapters;
    }

    public Integer getVolumes() {
        return volumes;
    }

    public String getAuthor() {
        return author;
    }

    public String getSynopsys() {
        return synopsys;
    }

    public String getType() {
        return type;
    }

    public MangaState getState() {
        return state;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public ArrayList<Score> getScores() {
        return scores;
    }

    public Integer getRank() {
        return rank;
    }
}

