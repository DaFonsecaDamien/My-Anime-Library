package com.example.myanimelibrary.infrastructure.mapper;

import com.example.myanimelibrary.domain.MangaScore;
import com.example.myanimelibrary.infrastructure.entities.MangaScoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class MangaScoreMapper {
    private final MangaMapper mangaMapper;

    @Autowired
    public MangaScoreMapper(@Lazy MangaMapper mangaMapper) {
        this.mangaMapper = mangaMapper;
    }

    public MangaScoreEntity FromModelToEntity(MangaScore score) {
        return new MangaScoreEntity(
                score.getId(),
                mangaMapper.FromModelToEntity(score.getManga()),
                score.getValue(),
                score.getNbVotes(),
                score.getPercent()
        );
    }

    public MangaScore FromEntityToModel(MangaScoreEntity scoreEntity) {
        return new MangaScore(
                scoreEntity.getId(),
                scoreEntity.getValue(),
                scoreEntity.getNbVotes(),
                scoreEntity.getPercent(),
                mangaMapper.FromEntityToModel(scoreEntity.getMangaEntity()));
    }
}
