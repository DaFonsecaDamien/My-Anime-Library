package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.Library;
import com.example.myanimelibrary.domain.Stack;
import com.example.myanimelibrary.domain.repositories.StackRepository;
import com.example.myanimelibrary.infrastructure.entities.StackEntity;
import com.example.myanimelibrary.infrastructure.exception.ResourceNotFoundException;
import com.example.myanimelibrary.infrastructure.jparepositories.JPAStackRepository;
import com.example.myanimelibrary.infrastructure.mapper.LibraryMapper;
import com.example.myanimelibrary.infrastructure.mapper.StackMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Primary
public class StackRepositoryInfra implements StackRepository {

    private final JPAStackRepository jpaStackRepository;
    private final LibraryRepositoryInfra libraryRepositoryInfra;
    private final StackMapper stackMapper;
    private final LibraryMapper libraryMapper;

    public StackRepositoryInfra(JPAStackRepository jpaStackRepository, LibraryRepositoryInfra libraryRepositoryInfra, StackMapper stackMapper, LibraryMapper libraryMapper) {
        this.jpaStackRepository = jpaStackRepository;
        this.libraryRepositoryInfra = libraryRepositoryInfra;
        this.stackMapper = stackMapper;
        this.libraryMapper = libraryMapper;
    }

    @Override
    public Stack saveStack(Stack stack) {
        StackEntity stackEntitySaved = jpaStackRepository.save(stackMapper.fromModelToEntity(stack));
        return stackMapper.fromEntityToModel(stackEntitySaved);
    }

    @Override
    public void deleteStack(Stack stack) {
        jpaStackRepository.delete(stackMapper.fromModelToEntity(stack));
    }

    @Override
    public void deleteStackId(Long stackId) {
        jpaStackRepository.deleteById(stackId);
    }

    @Override
    public boolean existStackWithNameInLibrary(String name, Long libraryId) {
        return jpaStackRepository.existsStackEntityByNameEqualsAndAndLibrary_Id(name, libraryId);
    }

    @Override
    public List<Stack> getAllStackFromLibrary(Library library) {
        List<StackEntity> stackEntitiesFound = jpaStackRepository.findAllByLibrary(libraryMapper.fromModelToEntity(library));
        return stackEntitiesFound.stream().map(stackMapper::fromEntityToModel).collect(Collectors.toList());
    }

    @Override
    public Stack getStackById(Long id) {
        Optional<StackEntity> stackEntityOptional = jpaStackRepository.findById(id);
        if (stackEntityOptional.isEmpty()) {
            throw new ResourceNotFoundException("stack not found");
        }
        return stackMapper.fromEntityToModel(stackEntityOptional.get());
    }

    @Override
    public List<Stack> searchStackByName(String name) {
        List<StackEntity> stackEntitiesFound = jpaStackRepository.findAllByNameLike(name);
        return stackEntitiesFound.stream().map(stackMapper::fromEntityToModel).collect(Collectors.toList());
    }


}
