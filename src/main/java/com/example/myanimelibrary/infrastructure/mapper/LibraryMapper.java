package com.example.myanimelibrary.infrastructure.mapper;

import com.example.myanimelibrary.domain.Library;
import com.example.myanimelibrary.infrastructure.entities.LibraryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryMapper {

    private final UserMapper userMapper;

    @Autowired
    public LibraryMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public LibraryEntity fromModelToEntity(Library library) {
        return new LibraryEntity(
                library.getId(),
                userMapper.fromModelToEntity(library.getUser())
        );
    }

    public Library fromEntityToModel(LibraryEntity libraryEntity) {
        return new Library(
                libraryEntity.getId(),
                userMapper.fromEntityToModel(libraryEntity.getUserEntity()),
                null
        );
    }
}
