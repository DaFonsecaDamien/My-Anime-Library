package com.example.myanimelibrary.infrastructure.request;

import com.example.myanimelibrary.domain.APIAnime;
import com.example.myanimelibrary.domain.AnimeState;
import com.example.myanimelibrary.domain.FilterOperationMode;

import java.util.List;

public class SearchAnimeRequest {

    private final String name;
    private final FilterOperationMode nameOperation;
    private final Integer year;
    private final FilterOperationMode yearOperation;
    private final String studio;
    private final FilterOperationMode studioOperation;
    private final String type;
    private final FilterOperationMode typeOperation;
    private final AnimeState state;
    private final FilterOperationMode stateOperation;
    private final List<String> genre;
    private final FilterOperationMode genreOperation;
    private final float average;
    private final FilterOperationMode averageOperation;
    private final Integer votes;
    private final FilterOperationMode votesOperation;
    private final Integer ranking;
    private final FilterOperationMode rankingOperation;

    public SearchAnimeRequest(String name, FilterOperationMode nameOperation, Integer year, FilterOperationMode yearOperation, String studio, String type, AnimeState state, List<String> genre, float average, FilterOperationMode averageOperation, Integer votes, FilterOperationMode votesOperation, Integer ranking, FilterOperationMode rankingOperation) {
        this.name = name;
        this.nameOperation = nameOperation;
        this.year = year;
        this.yearOperation = yearOperation;
        this.studio = studio;
        this.studioOperation = FilterOperationMode.EQUALS;
        this.type = type;
        this.typeOperation = FilterOperationMode.IN;
        this.state = state;
        this.stateOperation = FilterOperationMode.IN;
        this.genre = genre;
        this.genreOperation = FilterOperationMode.IN;
        this.average = average;
        this.averageOperation = averageOperation;
        this.votes = votes;
        this.votesOperation = votesOperation;
        this.ranking = ranking;
        this.rankingOperation = rankingOperation;
    }

    public String getName() {
        return name;
    }

    public FilterOperationMode getNameOperation() {
        return nameOperation;
    }

    public Integer getYear() {
        return year;
    }

    public FilterOperationMode getYearOperation() {
        return yearOperation;
    }

    public String getStudio() {
        return studio;
    }

    public FilterOperationMode getStudioOperation() {
        return studioOperation;
    }

    public String getType() {
        return type;
    }

    public FilterOperationMode getTypeOperation() {
        return typeOperation;
    }

    public AnimeState getState() {
        return state;
    }

    public FilterOperationMode getStateOperation() {
        return stateOperation;
    }

    public List<String> getGenre() {
        return genre;
    }

    public FilterOperationMode getGenreOperation() {
        return genreOperation;
    }

    public float getAverage() {
        return average;
    }

    public FilterOperationMode getAverageOperation() {
        return averageOperation;
    }

    public Integer getVotes() {
        return votes;
    }

    public FilterOperationMode getVotesOperation() {
        return votesOperation;
    }

    public Integer getRanking() {
        return ranking;
    }

    public FilterOperationMode getRankingOperation() {
        return rankingOperation;
    }
}
