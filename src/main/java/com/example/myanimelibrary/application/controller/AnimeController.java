package com.example.myanimelibrary.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animeList/anime")
public class AnimeController {

    @GetMapping("/add")
    public String addBook() {
        return "bookServicePort.addBook(bookDto)";
    }
}
