package com.example.myanimelibrary.infrastructure.mapper;

import com.example.myanimelibrary.domain.Stack;
import com.example.myanimelibrary.infrastructure.entities.StackEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StackMapper {

    public final LibraryMapper libraryMapper;

    @Autowired
    public StackMapper(LibraryMapper libraryMapper) {
        this.libraryMapper = libraryMapper;
    }

    public StackEntity fromModelToEntity(Stack stack){
        return new StackEntity(
                stack.getId(),
                stack.getName(),
                stack.getVisibility(),
                libraryMapper.fromModelToEntity(stack.getLibrary())
        );
    }

    public Stack fromEntityToModel(StackEntity stackEntity){
        return new Stack(
                stackEntity.getId(),
                stackEntity.getName(),
                null,
                null,
                stackEntity.getVisibility(),
                libraryMapper.fromEntityToModel(stackEntity.getLibrary())
        );
    }
}

