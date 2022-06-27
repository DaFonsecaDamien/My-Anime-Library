package com.example.myanimelibrary.application.controller;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.Score;
import com.example.myanimelibrary.domain.service.AnimeService;
import com.example.myanimelibrary.domain.service.ScoreService;
import com.example.myanimelibrary.domain.service.UserAnimeReviewService;
import com.example.myanimelibrary.infrastructure.request.CreateUserAnimeReviewRequest;
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
    private final UserAnimeReviewService userAnimeReviewService;
    private final ScoreService scoreService;

    @Autowired
    public AnimeController(AnimeService animeService, UserAnimeReviewService userAnimeReviewService, ScoreService scoreService) {
        this.animeService = animeService;
        this.userAnimeReviewService = userAnimeReviewService;
        this.scoreService = scoreService;
    }

    @GetMapping("/search")
    public List<Anime> SearchAnime() throws IOException {
        return animeService.searchAnime(new HashMap<>());
    }

    @GetMapping("/{id}")
    public Anime getAnimeById(@PathVariable("id") String id ){
        return animeService.getAnimeById(id);
    }

    @PostMapping("/{id}/createReview")
    public void createReview(@PathVariable("id") String id, @RequestBody CreateUserAnimeReviewRequest request){
        userAnimeReviewService.createAnimeReview(id ,request);
        Anime animeToUpdate = animeService.getAnimeById(id);
        System.out.println(animeToUpdate +" ///// "+animeToUpdate.getId());
        Score score = scoreService.getScoreByAnimeAndValue(request.getScore(), animeToUpdate);
        score.setNbVotes(score.getNbVotes()+1);
        scoreService.saveScore(score);
        List<Score> scoresAnime = scoreService.getAllscoreFromAnime(animeToUpdate);
        animeToUpdate.makeAverage(scoresAnime);
        animeToUpdate.updateNbVotes(scoresAnime);
        System.out.println(animeToUpdate +" ///// "+animeToUpdate.getId());
        animeService.saveAnime(animeToUpdate);
    }





}
