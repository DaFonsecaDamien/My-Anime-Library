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
    private float averageScore;
    private Integer nbVotes;
    private Integer ranking;

    public Anime(String id, Map<String, String> titles, String imageUrl, Integer year, Integer episodes, String durationPerEpisodes, String studio, String synopsys, String type, AnimeState state, List<String> genre, float averageScore, Integer nbVotes, Integer ranking) {
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
        this.averageScore = averageScore;
        this.nbVotes = nbVotes;
        this.ranking = ranking;
    }

    public void makeAverage(List<Score> scores){
        float totalVotes = 0;
        float totalScore = 0;

        for(Score score : scores){
            totalVotes += score.getNbVotes();
            totalScore += score.getValue()*score.getNbVotes();
        }
        this.averageScore = totalScore/totalVotes;
    }

    public void updateNbVotes(List<Score> scores){
        Integer totalVotes = 0;
        for(Score score : scores){
            totalVotes += score.getNbVotes();
        }
        this.nbVotes = totalVotes;
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

    public List<String> getGenre() {
        return genre;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public Integer getNbVotes() {
        return nbVotes;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }

    public void setNbVotes(Integer nbVotes) {
        this.nbVotes = nbVotes;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "averageScore=" + averageScore +
                '}';
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
