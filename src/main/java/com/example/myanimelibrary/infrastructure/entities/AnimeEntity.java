package com.example.myanimelibrary.infrastructure.entities;

import com.example.myanimelibrary.domain.AnimeState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table
public class AnimeEntity implements Serializable {

    @Id
    private String id;
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

    public AnimeEntity(String id, Map<String, String> titles, String imageUrl, Integer year, Integer episodes, String durationPerEpisodes, String studio, String synopsys, String type, AnimeState state, List<String> genre, float averageScore, Integer nbVotes, Integer ranking) {
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

    public AnimeEntity() {

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

}
