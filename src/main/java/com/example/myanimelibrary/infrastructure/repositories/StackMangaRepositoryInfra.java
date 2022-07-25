package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.StackManga;
import com.example.myanimelibrary.domain.repositories.StackMangaRepository;
import com.example.myanimelibrary.infrastructure.entities.StackMangaEntity;
import com.example.myanimelibrary.infrastructure.jparepositories.JPAStackMangaRepository;
import com.example.myanimelibrary.infrastructure.mapper.StackMangaMapper;
import com.example.myanimelibrary.infrastructure.mapper.StackMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Primary
public class StackMangaRepositoryInfra implements StackMangaRepository {

    private final StackMangaMapper stackMangaMapper;
    private final StackMapper stackMapper;
    private final JPAStackMangaRepository jpaStackMangaRepository;

    public StackMangaRepositoryInfra(StackMangaMapper stackMangaMapper, StackMapper stackMapper, JPAStackMangaRepository jpaStackMangaRepository) {
        this.stackMangaMapper = stackMangaMapper;
        this.stackMapper = stackMapper;
        this.jpaStackMangaRepository = jpaStackMangaRepository;
    }

    @Override
    public StackManga saveStackManga(StackManga stackManga) {
        StackMangaEntity stackMangaEntitySaved = jpaStackMangaRepository.save(stackMangaMapper.fromModelToEntity(stackManga));
        return stackMangaMapper.fromEntityToModel(stackMangaEntitySaved);
    }

    @Override
    public void deleteStackMangaById(Long stackMangaId) {
        jpaStackMangaRepository.deleteById(stackMangaId);
    }

    @Override
    public List<StackManga> getAllMangaFromStackId(Long stackId) {
        List<StackMangaEntity> stackMangaEntitiesFound = jpaStackMangaRepository.findAllByStackEntityId(stackId);
        return stackMangaEntitiesFound.stream().map(stackMangaMapper::fromEntityToModel).collect(Collectors.toList());
    }

    @Override
    public StackManga getStackMangaById(Long id) {
        return null;
    }

    @Override
    public boolean existMangaInStack(Long MangaId, Long stackId) {
        return jpaStackMangaRepository.existsStackMangaEntityByMangaEntity_IdAndStackEntity_Id(MangaId, stackId);
    }
}
