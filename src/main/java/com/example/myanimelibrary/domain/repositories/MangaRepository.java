package com.example.myanimelibrary.domain.repositories;

import com.example.myanimelibrary.domain.Manga;
import com.example.myanimelibrary.domain.SearchFilter;

import java.util.List;

public interface MangaRepository {
    Manga saveManga(Manga manga);

    Manga getMangaById(Long id);

    Manga findByTitlesContains(String Titles);

    boolean existsMangaEntityByTitlesContaining(String title);

    List<Manga> findByFilters(List<SearchFilter> filters);
}

