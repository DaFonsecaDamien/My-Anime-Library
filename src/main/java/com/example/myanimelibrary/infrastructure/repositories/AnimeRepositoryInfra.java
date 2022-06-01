package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.repositories.AnimeRepository;
import com.example.myanimelibrary.infrastructure.jparepositories.JPAAnimeRepository;
import com.example.myanimelibrary.infrastructure.mapper.AnimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AnimeRepositoryInfra implements AnimeRepository {

    private final JPAAnimeRepository jpaAnimeRepository;
    private final AnimeMapper animeMapper;

    @Autowired
    public AnimeRepositoryInfra(JPAAnimeRepository jpaAnimeRepository, AnimeMapper animeMapper) {
        this.jpaAnimeRepository = jpaAnimeRepository;
        this.animeMapper = animeMapper;
    }

}
