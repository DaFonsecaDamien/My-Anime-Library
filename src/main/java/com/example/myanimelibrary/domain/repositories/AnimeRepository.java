package com.example.myanimelibrary.domain.repositories;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.SearchFilter;

import java.util.List;

public interface AnimeRepository {

    Anime saveAnime(Anime anime);

    Anime getAnimeById(Long id);

    Anime findByTitlesContains(String Titles);

    boolean existsAnimeEntityByTitlesContaining(String title);

    List<Anime> findByFilters (List<SearchFilter> filters);


}
