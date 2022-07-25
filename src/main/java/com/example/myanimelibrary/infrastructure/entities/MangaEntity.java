package com.example.myanimelibrary.infrastructure.entities;

import com.example.myanimelibrary.domain.MangaState;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Table
public class MangaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ElementCollection
    private Map<String, String> titles;
    private String imageUrl;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer chapters;
    private Integer volumes;
    private String author;
    @Enumerated(EnumType.STRING)
    private MangaState state;
    @Lob
    private String synopsys;
    private String type;
    @ElementCollection
    private List<String> genre;
    private float averageScore;
    private Integer nbVotes;
    private Integer ranking;

    public MangaEntity() {
    }

    public MangaEntity(Long id, Map<String, String> titles, String imageUrl, LocalDate startDate, Integer chapters, Integer volumes, String author, MangaState state, String synopsys, String type, List<String> genre, float averageScore, Integer nbVotes, Integer ranking) {
        this.id = id;
        this.titles = titles;
        this.imageUrl = imageUrl;
        this.startDate = startDate;
        this.chapters = chapters;
        this.volumes = volumes;
        this.author = author;
        this.state = state;
        this.synopsys = synopsys;
        this.type = type;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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

    public MangaState getState() {
        return state;
    }

    public void setState(MangaState state) {
        this.state = state;
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
