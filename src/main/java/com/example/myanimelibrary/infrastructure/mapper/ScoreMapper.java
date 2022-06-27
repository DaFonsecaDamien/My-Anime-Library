package com.example.myanimelibrary.infrastructure.mapper;

import com.example.myanimelibrary.domain.Score;
import com.example.myanimelibrary.infrastructure.entities.ScoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ScoreMapper {

    private final AnimeMapper animeMapper;

    @Autowired
    public ScoreMapper(@Lazy AnimeMapper animeMapper) {
        this.animeMapper = animeMapper;
    }

    public ScoreEntity FromModelToEntity(Score score){
        return new ScoreEntity(
                score.getId(),
                score.getValue(),
                score.getNbVotes(),
                score.getPercent(),
                animeMapper.FromModelToEntity(score.getAnime())
        );
    }

    public Score FromEntityToModel(ScoreEntity scoreEntity){
        return new Score(
                scoreEntity.getId(),
                scoreEntity.getValue(),
                scoreEntity.getNbVotes(),
                scoreEntity.getPercent(),
                animeMapper.FromEntityToModel(scoreEntity.getAnime()));
    }
}
