package com.example.myanimelibrary.infrastructure.web.controller;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.Score;
import com.example.myanimelibrary.domain.UserAnimeReview;
import com.example.myanimelibrary.domain.service.AnimeService;
import com.example.myanimelibrary.domain.service.ScoreService;
import com.example.myanimelibrary.domain.service.UserAnimeReviewService;
import com.example.myanimelibrary.infrastructure.request.CreateUserAnimeReviewRequest;
import com.example.myanimelibrary.infrastructure.request.SearchAnimeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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

    @PostMapping("/search")
    public ResponseEntity<List<Anime>> SearchAnime(@RequestBody SearchAnimeRequest request) throws IOException {
        return ResponseEntity.ok(animeService.searchAnime(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> getAnimeById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(animeService.getAnimeById(id));
    }

    @PostMapping("/{id}/createReview")
    public ResponseEntity<UserAnimeReview> createReview(@PathVariable("id") Long id, @RequestBody CreateUserAnimeReviewRequest request) {
        UserAnimeReview savedReview = userAnimeReviewService.createAnimeReview(id, request);
        Anime animeToUpdate = animeService.getAnimeById(id);
        System.out.println(animeToUpdate + " ///// " + animeToUpdate.getId());
        Score score = scoreService.getScoreByAnimeAndValue(request.getScore(), animeToUpdate);
        score.setNbVotes(score.getNbVotes() + 1);
        scoreService.saveScore(score);
        List<Score> scoresAnime = scoreService.getAllscoreFromAnime(animeToUpdate);
        animeToUpdate.makeAverage(scoresAnime);
        animeToUpdate.updateNbVotes(scoresAnime);
        System.out.println(animeToUpdate + " ///// " + animeToUpdate.getId());
        animeService.saveAnime(animeToUpdate);
        return ResponseEntity.ok(savedReview);
    }
}
