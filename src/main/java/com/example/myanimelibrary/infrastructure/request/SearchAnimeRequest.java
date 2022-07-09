package com.example.myanimelibrary.infrastructure.request;

import com.example.myanimelibrary.domain.SearchFilter;

import java.util.List;

public class SearchAnimeRequest {

    private List<SearchFilter> filters;

    public SearchAnimeRequest(List<SearchFilter> filters) {
        this.filters = filters;
    }

    public SearchAnimeRequest() {
    }

    public List<SearchFilter> getFilters() {
        return filters;
    }

}
