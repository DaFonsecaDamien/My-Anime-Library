package com.example.myanimelibrary.infrastructure.entities;

import com.example.myanimelibrary.domain.AnimeState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Table
public class AnimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ElementCollection
    private Map<String, String> titles;
    private String imageUrl;
    private Integer year;
    private Integer episodes;
    private String durationPerEpisodes;
    private String studio;
    @Lob
    private String synopsys;
    private String type;
    @Enumerated(EnumType.STRING)
    private AnimeState state;
    @ElementCollection
    private List<String> genre;
    private float averageScore;
    private Integer nbVotes;
    private Integer ranking;

    public AnimeEntity() {
    }

    public AnimeEntity(Long id, Map<String, String> titles, String imageUrl, Integer year, Integer episodes, String durationPerEpisodes, String studio, String synopsys, String type, AnimeState state, List<String> genre, float averageScore, Integer nbVotes, Integer ranking) {
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public String getDurationPerEpisodes() {
        return durationPerEpisodes;
    }

    public void setDurationPerEpisodes(String durationPerEpisodes) {
        this.durationPerEpisodes = durationPerEpisodes;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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

    public AnimeState getState() {
        return state;
    }

    public void setState(AnimeState state) {
        this.state = state;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
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
}
