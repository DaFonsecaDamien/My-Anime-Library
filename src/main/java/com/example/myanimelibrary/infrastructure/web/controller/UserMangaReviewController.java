package com.example.myanimelibrary.infrastructure.web.controller;

import com.example.myanimelibrary.domain.Manga;
import com.example.myanimelibrary.domain.MangaScore;
import com.example.myanimelibrary.domain.UserMangaReview;
import com.example.myanimelibrary.domain.service.MangaScoreService;
import com.example.myanimelibrary.domain.service.MangaService;
import com.example.myanimelibrary.domain.service.UserMangaReviewService;
import com.example.myanimelibrary.infrastructure.request.UpdateUserMangaReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animeList/mangaReview")
public class UserMangaReviewController {

    private final UserMangaReviewService userMangaReviewService;
    private final MangaScoreService scoreService;
    private final MangaService mangaService;

    @Autowired
    public UserMangaReviewController(UserMangaReviewService userMangaReviewService, MangaScoreService scoreService, MangaService mangaService) {
        this.userMangaReviewService = userMangaReviewService;
        this.scoreService = scoreService;
        this.mangaService = mangaService;
    }

    @PutMapping("/{id}/update")
    public void updateUserMangaReview(@PathVariable("id") Long id, @RequestBody UpdateUserMangaReviewRequest request) {
        userMangaReviewService.updateMangaReview(id, request);
    }

    @GetMapping("/getReviewByAnime")
    public ResponseEntity<List<UserMangaReview>> getReviewByManga(@RequestParam("id") Long idAnime) {
        return ResponseEntity.ok(userMangaReviewService.getAllByMangaId(idAnime));
    }

    @DeleteMapping("/{id}/delete")
    public void deleteUserMangaReview(@PathVariable("id") Long id) {
        UserMangaReview userMangaReview = userMangaReviewService.getById(id);
        userMangaReviewService.deleteById(id);
        MangaScore score = scoreService.getScoreByMangaAndValue(userMangaReview.getScore(), userMangaReview.getManga());
        score.setNbVotes(score.getNbVotes() - 1);
        scoreService.saveScore(score);
        Manga mangaToUpdate = score.getManga();
        List<MangaScore> scores = scoreService.getAllscoreFromManga(mangaToUpdate);
        mangaToUpdate.makeAverage(scores);
        mangaService.saveManga(mangaToUpdate);
    }

    @GetMapping("/myReviews")
    public ResponseEntity<List<UserMangaReview>> getAllMangaReviewByUserId(@RequestParam("user") Long id) {
        return ResponseEntity.ok(userMangaReviewService.getAllMangaReviewByUserId(id));
    }
}
