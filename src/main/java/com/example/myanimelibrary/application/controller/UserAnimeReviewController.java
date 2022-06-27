package com.example.myanimelibrary.application.controller;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.Score;
import com.example.myanimelibrary.domain.UserAnimeReview;
import com.example.myanimelibrary.domain.service.AnimeService;
import com.example.myanimelibrary.domain.service.ScoreService;
import com.example.myanimelibrary.domain.service.UserAnimeReviewService;
import com.example.myanimelibrary.infrastructure.request.UpdateUserAnimeReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animeReview")
public class UserAnimeReviewController {

    private final UserAnimeReviewService userAnimeReviewService;
    private final ScoreService scoreService;
    private final AnimeService animeService;

    @Autowired
    public UserAnimeReviewController(UserAnimeReviewService userAnimeReviewService, ScoreService scoreService, AnimeService animeService) {
        this.userAnimeReviewService = userAnimeReviewService;
        this.scoreService = scoreService;
        this.animeService = animeService;
    }

    @PutMapping("/{id}/update")
    public void createUserAnimeReview(@PathVariable("id") String id, @RequestBody UpdateUserAnimeReviewRequest request){
        userAnimeReviewService.updateAnimeReview(id, request);
    }

    @GetMapping("/getReviewByAnime")
    public List<UserAnimeReview> getReviewByAnime(@RequestParam("id") String idAnime){
        return userAnimeReviewService.getAllByAnimeId(idAnime);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteUserAnimeReview(@PathVariable("id") String id){
        UserAnimeReview userAnimeReview = userAnimeReviewService.getById(id);
        userAnimeReviewService.deleteById(id);
        Score score = scoreService.getScoreByAnimeAndValue(userAnimeReview.getScore(), userAnimeReview.getAnime());
        score.setNbVotes(score.getNbVotes()-1);
        scoreService.saveScore(score);
        Anime animeToUpdate = score.getAnime();
        List<Score> scores = scoreService.getAllscoreFromAnime(animeToUpdate);
        animeToUpdate.makeAverage(scores);
        animeService.saveAnime(animeToUpdate);
    }
}
