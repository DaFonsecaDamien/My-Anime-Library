package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.Library;
import com.example.myanimelibrary.domain.repositories.LibraryRepository;
import com.example.myanimelibrary.infrastructure.entities.LibraryEntity;
import com.example.myanimelibrary.infrastructure.exception.ResourceNotFoundException;
import com.example.myanimelibrary.infrastructure.jparepositories.JPALibraryRepository;
import com.example.myanimelibrary.infrastructure.mapper.LibraryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
public class LibraryRepositoryInfra implements LibraryRepository {

    private final JPALibraryRepository jpaLibraryRepository;
    private final LibraryMapper libraryMapper;

    @Autowired
    public LibraryRepositoryInfra(JPALibraryRepository jpaLibraryRepository, LibraryMapper libraryMapper) {
        this.jpaLibraryRepository = jpaLibraryRepository;
        this.libraryMapper = libraryMapper;
    }

    @Override
    public Library saveLibrary(LibraryEntity libraryEntity) {
        return libraryMapper.fromEntityToModel(jpaLibraryRepository.save(libraryEntity));
    }

    @Override
    public Library getLibraryById(Long id) {
        Optional<LibraryEntity> libraryEntityOptional = jpaLibraryRepository.findById(id);
        if (libraryEntityOptional.isEmpty()) {
            throw new ResourceNotFoundException("Library Not Found");
        }
        return libraryMapper.fromEntityToModel(libraryEntityOptional.get());
    }

    @Override
    public Library getLibraryByUserId(Long userId) {
        return libraryMapper.fromEntityToModel(jpaLibraryRepository.getLibraryEntityByUserEntity_Id(userId));
    }
}
