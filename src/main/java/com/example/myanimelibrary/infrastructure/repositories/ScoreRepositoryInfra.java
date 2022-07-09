package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.Score;
import com.example.myanimelibrary.domain.repositories.ScoreRepository;
import com.example.myanimelibrary.infrastructure.entities.ScoreEntity;
import com.example.myanimelibrary.infrastructure.jparepositories.JPAScoreRepository;
import com.example.myanimelibrary.infrastructure.mapper.AnimeMapper;
import com.example.myanimelibrary.infrastructure.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScoreRepositoryInfra implements ScoreRepository {

    private final JPAScoreRepository jpaScoreRepository;
    private final ScoreMapper scoreMapper;
    private final AnimeMapper animeMapper;

    @Autowired
    public ScoreRepositoryInfra(JPAScoreRepository jpaScoreRepository, ScoreMapper scoreMapper, AnimeMapper animeMapper) {
        this.jpaScoreRepository = jpaScoreRepository;
        this.scoreMapper = scoreMapper;
        this.animeMapper = animeMapper;
    }

    @Override
    public List<Score> saveScoreGenerated(List<Score> scores) {
        List<ScoreEntity> scoresToSave = scores.stream().map(scoreMapper::FromModelToEntity).collect(Collectors.toList());
        jpaScoreRepository.saveAll(scoresToSave);
        return scores;
    }

    @Override
    public Score getScoreByValueAndEntity(Integer value, Anime anime) {
        return scoreMapper.FromEntityToModel(
                jpaScoreRepository.getByAnimeEntityAndValue(animeMapper.FromModelToEntity(anime), value)
        );
    }

    @Override
    public void saveScore(Score score) {
        jpaScoreRepository.save(scoreMapper.FromModelToEntity(score));
    }

    @Override
    public List<Score> getAllScoreFromAnime(Anime anime) {
        return jpaScoreRepository.getAllByAnimeEntity(animeMapper.FromModelToEntity(anime))
                .stream()
                .map(scoreMapper::FromEntityToModel)
                .collect(Collectors.toList());
    }
}
