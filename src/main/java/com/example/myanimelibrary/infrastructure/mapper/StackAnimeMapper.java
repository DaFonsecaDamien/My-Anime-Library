package com.example.myanimelibrary.infrastructure.mapper;

import com.example.myanimelibrary.domain.StackAnime;
import com.example.myanimelibrary.infrastructure.entities.StackAnimeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StackAnimeMapper {

    private final AnimeMapper animeMapper;
    private final StackMapper stackMapper;

    @Autowired
    public StackAnimeMapper(AnimeMapper animeMapper, StackMapper stackMapper) {
        this.animeMapper = animeMapper;
        this.stackMapper = stackMapper;
    }

    public StackAnime fromEntityToModel(StackAnimeEntity stackAnimeEntity){
        return new StackAnime(
                stackAnimeEntity.getId(),
                animeMapper.FromEntityToModel(stackAnimeEntity.getAnimeEntity()),
                stackMapper.fromEntityToModel(stackAnimeEntity.getStackEntity())
        );
    }

    public StackAnimeEntity fromModelToEntity(StackAnime stackAnime){
        return new StackAnimeEntity(
                stackAnime.getId(),
                stackMapper.fromModelToEntity(stackAnime.getStack()),
                animeMapper.FromModelToEntity(stackAnime.getAnime())
                );
    }

}
