package com.example.myanimelibrary.domain.repositories;

import com.example.myanimelibrary.domain.Library;
import com.example.myanimelibrary.domain.Stack;

import java.util.List;

public interface StackRepository {

    Stack saveStack(Stack stack);

    void deleteStack(Stack stack);

    void deleteStackId(Long stackId);

    List<Stack> getAllStackFromLibrary(Library library);

    Stack getStackById(Long id);

    List<Stack> searchStackByName(String name);

    boolean existStackWithNameInLibrary(String name, Long libraryId);


}
