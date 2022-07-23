package com.example.myanimelibrary.infrastructure.mapper;

import com.example.myanimelibrary.domain.StackManga;
import com.example.myanimelibrary.infrastructure.entities.StackMangaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StackMangaMapper {
    private final MangaMapper mangaMapper;
    private final StackMapper stackMapper;

    @Autowired
    public StackMangaMapper(MangaMapper mangaMapper, StackMapper stackMapper) {
        this.mangaMapper = mangaMapper;
        this.stackMapper = stackMapper;
    }

    public StackManga fromEntityToModel(StackMangaEntity stackMangaEntity) {
        return new StackManga(
                stackMangaEntity.getId(),
                mangaMapper.FromEntityToModel(stackMangaEntity.getMangaEntity()),
                stackMapper.fromEntityToModel(stackMangaEntity.getStackEntity())
        );
    }

    public StackMangaEntity fromModelToEntity(StackManga stackManga) {
        return new StackMangaEntity(
                stackManga.getId(),
                mangaMapper.FromModelToEntity(stackManga.getManga()),
                stackMapper.fromModelToEntity(stackManga.getStack())
        );
    }
}
