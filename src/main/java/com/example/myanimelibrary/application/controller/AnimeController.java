package com.example.myanimelibrary.application.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animeList/anime")
public class AnimeController {

    @GetMapping("/add")
    public String addBook() {
        return "bookServicePort.addBook(bookDto)";
    }

    
}
