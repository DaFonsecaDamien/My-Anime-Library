package com.example.myanimelibrary.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Manga {

    private Long id;
    private Map<String, String> titles;
    private String imageUrl;
    private LocalDate startDate;
    private Integer chapters;
    private Integer volumes;
    private String author;
    private String synopsys;
    private String type;
    private MangaState state;
    private List<String> genres;
    private float averageScore;
    private Integer nbVotes;
    private Integer ranking;

    public Manga(Long id, Map<String, String> titles, String imageUrl, LocalDate startDate, Integer chapters, Integer volumes, String author, String synopsys, String type, MangaState state, List<String> genres, float averageScore, Integer nbVotes, Integer ranking) {
        this.id = id;
        this.titles = titles;
        this.imageUrl = imageUrl;
        this.startDate = startDate;
        this.chapters = chapters;
        this.volumes = volumes;
        this.author = author;
        this.synopsys = synopsys;
        this.type = type;
        this.state = state;
        this.genres = genres;
        this.averageScore = averageScore;
        this.nbVotes = nbVotes;
        this.ranking = ranking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, String> getTitles() {
        return titles;
    }

    public void setTitles(Map<String, String> titles) {
        this.titles = titles;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getChapters() {
        return chapters;
    }

    public void setChapters(Integer chapters) {
        this.chapters = chapters;
    }

    public Integer getVolumes() {
        return volumes;
    }

    public void setVolumes(Integer volumes) {
        this.volumes = volumes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSynopsys() {
        return synopsys;
    }

    public void setSynopsys(String synopsys) {
        this.synopsys = synopsys;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MangaState getState() {
        return state;
    }

    public void setState(MangaState state) {
        this.state = state;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }

    public Integer getNbVotes() {
        return nbVotes;
    }

    public void setNbVotes(Integer nbVotes) {
        this.nbVotes = nbVotes;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void makeAverage(List<MangaScore> scores) {
        float totalVotes = 0;
        float totalScore = 0;

        for (MangaScore score : scores) {
            totalVotes += score.getNbVotes();
            totalScore += score.getValue() * score.getNbVotes();
        }
        this.averageScore = totalScore / totalVotes;
    }

    public void updateNbVotes(List<MangaScore> scores) {
        Integer totalVotes = 0;
        for (MangaScore score : scores) {
            totalVotes += score.getNbVotes();
        }
        this.nbVotes = totalVotes;
    }
}
