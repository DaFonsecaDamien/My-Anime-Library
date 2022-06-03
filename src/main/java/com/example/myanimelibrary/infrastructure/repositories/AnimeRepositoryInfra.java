package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.Score;
import com.example.myanimelibrary.domain.SearchFilter;
import com.example.myanimelibrary.domain.repositories.AnimeRepository;
import com.example.myanimelibrary.infrastructure.entities.AnimeEntity;
import com.example.myanimelibrary.infrastructure.jparepositories.JPAAnimeRepository;
import com.example.myanimelibrary.infrastructure.mapper.AnimeMapper;
import com.example.myanimelibrary.infrastructure.mapper.ScoreMapper;
import com.example.myanimelibrary.infrastructure.mapper.SpecificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@Primary
public class AnimeRepositoryInfra implements AnimeRepository {

    private final JPAAnimeRepository jpaAnimeRepository;
    private final AnimeMapper animeMapper;
    private final ScoreMapper scoreMapper;

    @Autowired
    public AnimeRepositoryInfra(JPAAnimeRepository jpaAnimeRepository, AnimeMapper animeMapper, ScoreMapper scoreMapper) {
        this.jpaAnimeRepository = jpaAnimeRepository;
        this.animeMapper = animeMapper;
        this.scoreMapper = scoreMapper;
    }

    @Override
    public List<AnimeEntity> findByParameters(List<SearchFilter> filters) {
        return jpaAnimeRepository.findAll(SpecificationMapper.FromSearchFilterToSpecification(filters));
    }

    @Override
    public AnimeEntity getAnimeById(String id) {
        return jpaAnimeRepository.getAnimeEntityById(id);
    }

    @Override
    public void saveAnime(Anime anime) {
        jpaAnimeRepository.save(new AnimeEntity(
                UUID.randomUUID().toString(),
                anime.getTitles(),
                anime.getImageUrl(),
                anime.getYear(),
                anime.getEpisodes(),
                anime.getDurationPerEpisodes(),
                anime.getStudio(),
                anime.getSynopsys(),
                anime.getType(),
                anime.getState(),
                anime.getGenre(),
                Score.generateDefaultScoreList().stream().map(scoreMapper::FromModelToEntity).collect(Collectors.toList()),
                anime.getAverageScore(),
                anime.getNbVotes(),
                anime.getRanking()
        ));
    }

    @Override
    public AnimeEntity findByTitlesContains(String title) {
        return jpaAnimeRepository.findByTitlesContains(title);
    }

    @Override
    public boolean existsAnimeEntityByTitlesContaining(String title) {
        return jpaAnimeRepository.existsAnimeEntityByTitlesContaining(title);
    }
}
