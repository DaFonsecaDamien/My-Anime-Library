package com.example.myanimelibrary.application.controller;

import com.example.myanimelibrary.domain.UserAnimeReview;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animeList/anime")
public class LibraryControler {

    @PostMapping("/getReviewByAnime")
    public void getReviewByAnime(@RequestParam("id") String idAnime){
    }
}
