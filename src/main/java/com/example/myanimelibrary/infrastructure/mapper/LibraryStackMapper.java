package com.example.myanimelibrary.infrastructure.mapper;

import com.example.myanimelibrary.domain.LibraryStack;
import com.example.myanimelibrary.infrastructure.entities.LibraryStackEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryStackMapper {

    private final LibraryMapper libraryMapper;
    private final StackMapper stackMapper;

    @Autowired
    public LibraryStackMapper(LibraryMapper libraryMapper, StackMapper stackMapper) {
        this.libraryMapper = libraryMapper;
        this.stackMapper = stackMapper;
    }

    public LibraryStack fromEntityToModel(LibraryStackEntity libraryStackEntity){
        return new LibraryStack(
                libraryMapper.fromEntityToModel(libraryStackEntity.getLibraryEntity()),
                stackMapper.fromEntityToModel(libraryStackEntity.getStack())
        );
    }

    public LibraryStackEntity fromModelToEntity(LibraryStack libraryStack){
        return new LibraryStackEntity(
                libraryMapper.fromModelToEntity(libraryStack.getLibrary()),
                stackMapper.fromModelToEntity(libraryStack.getStacks())
        );
    }

}
