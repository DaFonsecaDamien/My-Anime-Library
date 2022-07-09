package com.example.myanimelibrary.domain.repositories;

import com.example.myanimelibrary.domain.Library;
import com.example.myanimelibrary.infrastructure.entities.LibraryEntity;

public interface LibraryRepository {

    Library saveLibrary(LibraryEntity libraryEntity);

    Library getLibraryById(Long id);

    Library getLibraryByUserId(Long userId);
}
