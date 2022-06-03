package com.example.myanimelibrary.infrastructure.mapper;

import com.example.myanimelibrary.domain.Score;
import com.example.myanimelibrary.infrastructure.entities.ScoreEntity;
import org.springframework.stereotype.Component;

@Component
public class ScoreMapper {

    public ScoreEntity FromModelToEntity(Score score){
        return new ScoreEntity(
                score.getId(),
                score.getValue(),
                score.getNbVotes(),
                score.getPercent()
        );
    }

    public Score FromEntityToModel(ScoreEntity scoreEntity){
        return new Score(
                scoreEntity.getId(),
                scoreEntity.getValue(),
                scoreEntity.getNbVotes(),
                scoreEntity.getPercent());
    }
}
