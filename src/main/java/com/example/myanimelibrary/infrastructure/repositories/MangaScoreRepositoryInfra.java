package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.Manga;
import com.example.myanimelibrary.domain.MangaScore;
import com.example.myanimelibrary.domain.repositories.MangaScoreRepository;
import com.example.myanimelibrary.infrastructure.entities.MangaScoreEntity;
import com.example.myanimelibrary.infrastructure.jparepositories.JPAMangaScoreRepository;
import com.example.myanimelibrary.infrastructure.mapper.MangaMapper;
import com.example.myanimelibrary.infrastructure.mapper.MangaScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MangaScoreRepositoryInfra implements MangaScoreRepository {
    private final JPAMangaScoreRepository jpaScoreRepository;
    private final MangaScoreMapper scoreMapper;
    private final MangaMapper mangaMapper;

    @Autowired
    public MangaScoreRepositoryInfra(JPAMangaScoreRepository jpaScoreRepository, MangaScoreMapper scoreMapper, MangaMapper mangaMapper) {
        this.jpaScoreRepository = jpaScoreRepository;
        this.scoreMapper = scoreMapper;
        this.mangaMapper = mangaMapper;
    }

    @Override
    public List<MangaScore> saveScoreGenerated(List<MangaScore> scores) {
        List<MangaScoreEntity> scoresToSave = scores.stream().map(scoreMapper::FromModelToEntity).collect(Collectors.toList());
        jpaScoreRepository.saveAll(scoresToSave);
        return scores;
    }

    @Override
    public MangaScore getScoreByValueAndEntity(Integer value, Manga manga) {
        return scoreMapper.FromEntityToModel(
                jpaScoreRepository.getByMangaEntityAndValue(mangaMapper.FromModelToEntity(manga), value)
        );
    }

    @Override
    public void saveScore(MangaScore score) {
        jpaScoreRepository.save(scoreMapper.FromModelToEntity(score));
    }

    @Override
    public List<MangaScore> getAllScoreFromManga(Manga manga) {
        return jpaScoreRepository.getAllByMangaEntity(mangaMapper.FromModelToEntity(manga))
                .stream()
                .map(scoreMapper::FromEntityToModel)
                .collect(Collectors.toList());
    }
}
