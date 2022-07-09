package com.example.myanimelibrary.domain.service;

import com.example.myanimelibrary.domain.Library;
import com.example.myanimelibrary.domain.repositories.LibraryRepository;

public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public Library getLibraryById(Long id){
        return libraryRepository.getLibraryById(id);
    }

    public Library getLibraryByUserId(Long userId){
        return libraryRepository.getLibraryByUserId(userId);
    }

//    public Library createLibrary(User user, String name){
//
//    }
}
