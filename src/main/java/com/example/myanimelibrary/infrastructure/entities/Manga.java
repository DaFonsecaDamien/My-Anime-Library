package com.example.myanimelibrary.infrastructure.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Table
public class Manga {

    @Id
    private String id;
    @ElementCollection
    private Map<String, String> titles;
    private String imageUrl;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer chapters;
    private Integer volumes;
    private String author;
    private String synopsys;
    private String type;
    @Enumerated(EnumType.ORDINAL)
    private MangaState state;
    @ElementCollection
    private List<String> genre;
    @OneToMany
    private List<ScoreEntity> scoreEntities;
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
