package com.example.myanimelibrary.domain.repositories;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.SearchFilter;
import com.example.myanimelibrary.infrastructure.entities.AnimeEntity;
import com.example.myanimelibrary.infrastructure.entities.ScoreEntity;
import com.example.myanimelibrary.infrastructure.jparepositories.JPAAnimeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository {


    Anime saveAnime(Anime anime);

    AnimeEntity getAnimeById(String id);

    AnimeEntity findByTitlesContains(String Titles);

    boolean existsAnimeEntityByTitlesContaining(String title);

    List<AnimeEntity> findByParameters (List<SearchFilter> filters);


}
