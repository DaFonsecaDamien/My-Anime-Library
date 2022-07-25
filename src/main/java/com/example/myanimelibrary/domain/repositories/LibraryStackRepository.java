package com.example.myanimelibrary.domain.repositories;

import com.example.myanimelibrary.domain.LibraryStack;

public interface LibraryStackRepository {

    LibraryStack saveStackInLibrary(LibraryStack libraryStack);

    void deleteStackFromLibrary(LibraryStack libraryStack);
}
