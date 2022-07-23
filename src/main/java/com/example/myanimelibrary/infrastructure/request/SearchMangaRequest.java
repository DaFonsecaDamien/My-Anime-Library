package com.example.myanimelibrary.infrastructure.request;

import com.example.myanimelibrary.domain.SearchFilter;

import java.util.List;

public class SearchMangaRequest {
    private List<SearchFilter> filters;

    public SearchMangaRequest(List<SearchFilter> filters) {
        this.filters = filters;
    }

    public SearchMangaRequest() {
    }

    public List<SearchFilter> getFilters() {
        return filters;
    }

}
