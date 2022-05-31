package com.example.myanimelibrary.infrastructure.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table
public class Anime {

    @Id
    private String id;
    @ElementCollection
    private Map<String, String> titles;
    private String imageUrl;
    private Integer year;
    private Integer episodes;
    private String durationPerEpisodes;
    private String studio;
    private String synopsys;
    private String type;
    @Enumerated(EnumType.ORDINAL)
    private AnimeState state;
    @ElementCollection
    private List<String> genre;
    @OneToMany()
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
