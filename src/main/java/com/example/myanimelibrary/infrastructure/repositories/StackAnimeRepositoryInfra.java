package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.StackAnime;
import com.example.myanimelibrary.domain.repositories.StackAnimeRepository;
import com.example.myanimelibrary.infrastructure.entities.StackAnimeEntity;
import com.example.myanimelibrary.infrastructure.jparepositories.JPAStackAnimeRepository;
import com.example.myanimelibrary.infrastructure.mapper.StackAnimeMapper;
import com.example.myanimelibrary.infrastructure.mapper.StackMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Primary
public class StackAnimeRepositoryInfra implements StackAnimeRepository {

    private final StackAnimeMapper stackAnimeMapper;
    private final StackMapper stackMapper;
    private final JPAStackAnimeRepository jpaStackAnimeRepository;

    public StackAnimeRepositoryInfra(StackAnimeMapper stackAnimeMapper, StackMapper stackMapper, JPAStackAnimeRepository jpaStackAnimeRepository) {
        this.stackAnimeMapper = stackAnimeMapper;
        this.stackMapper = stackMapper;
        this.jpaStackAnimeRepository = jpaStackAnimeRepository;
    }

    @Override
    public StackAnime saveStackAnime(StackAnime stackAnime) {
        StackAnimeEntity stackAnimeEntitySaved = jpaStackAnimeRepository.save(stackAnimeMapper.fromModelToEntity(stackAnime));
        return stackAnimeMapper.fromEntityToModel(stackAnimeEntitySaved);
    }

    @Override
    public void deleteStackAnimeById(Long stackAnimeId) {
        jpaStackAnimeRepository.deleteById(stackAnimeId);
    }

    @Override
    public List<StackAnime> getAllAnimeFromStackId(Long stackId) {
        List<StackAnimeEntity> stackAnimeEntitiesFound = jpaStackAnimeRepository
                .findAllByStackEntityId(stackId);
        return stackAnimeEntitiesFound.stream().map(stackAnimeMapper::fromEntityToModel).collect(Collectors.toList());
    }

    @Override
    public StackAnime getStackAnimeById(Long id) {
        return null;
    }

    @Override
    public boolean existAnimeInStack(Long animeId, Long stackId) {
        return jpaStackAnimeRepository.existsStackAnimeEntityByAnimeEntity_IdAndStackEntity_Id(animeId, stackId);
    }
}
