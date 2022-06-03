package com.example.myanimelibrary.application.controller;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.service.AnimeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/animeList/anime")
public class AnimeController {

    private final AnimeService animeService;
    private final Gson gson = new Gson();
    @Autowired
    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping("/search")
    public String addBook() throws IOException {
        return gson.toJson(animeService.searchAnime(new HashMap<>()));
    }

    @GetMapping("/{id}")
    public Anime getAnime(@PathVariable("id") String id ){
        return animeService.getAnimeById(id);
    }






}
