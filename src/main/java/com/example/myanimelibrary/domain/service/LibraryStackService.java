package com.example.myanimelibrary.domain.service;

public class LibraryStackService {

    private final StackAnimeService stackAnimeService;
    private final StackMangaService stackMangaService;

    public LibraryStackService(StackAnimeService stackAnimeService, StackMangaService stackMangaService) {
        this.stackAnimeService = stackAnimeService;
        this.stackMangaService = stackMangaService;
    }


}
