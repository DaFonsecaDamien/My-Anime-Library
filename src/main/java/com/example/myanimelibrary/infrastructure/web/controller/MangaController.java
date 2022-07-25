package com.example.myanimelibrary.infrastructure.web.controller;

import com.example.myanimelibrary.domain.Manga;
import com.example.myanimelibrary.domain.MangaScore;
import com.example.myanimelibrary.domain.UserMangaReview;
import com.example.myanimelibrary.domain.service.MangaScoreService;
import com.example.myanimelibrary.domain.service.MangaService;
import com.example.myanimelibrary.domain.service.UserMangaReviewService;
import com.example.myanimelibrary.infrastructure.request.CreateUserMangaReviewRequest;
import com.example.myanimelibrary.infrastructure.request.SearchMangaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/animeList/manga")
public class MangaController {

    private final MangaService mangaService;
    private final UserMangaReviewService userMangaReviewService;
    private final MangaScoreService scoreService;

    @Autowired
    public MangaController(MangaService mangaService, UserMangaReviewService userMangaReviewService, MangaScoreService scoreService) {
        this.mangaService = mangaService;
        this.userMangaReviewService = userMangaReviewService;
        this.scoreService = scoreService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Manga>> SearchManga(@RequestBody SearchMangaRequest request) throws IOException {
        return ResponseEntity.ok(mangaService.searchManga(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manga> getMangaById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mangaService.getMangaById(id));
    }

    @PostMapping("/{id}/createReview")
    public ResponseEntity<UserMangaReview> createReview(@PathVariable("id") Long id, @RequestBody CreateUserMangaReviewRequest request) {
        UserMangaReview savedReview = userMangaReviewService.createMangaReview(id, request);
        Manga MangaToUpdate = mangaService.getMangaById(id);
        System.out.println(MangaToUpdate + " ///// " + MangaToUpdate.getId());
        MangaScore score = scoreService.getScoreByMangaAndValue(request.getScore(), MangaToUpdate);
        score.setNbVotes(score.getNbVotes() + 1);
        scoreService.saveScore(score);
        List<MangaScore> scoresManga = scoreService.getAllscoreFromManga(MangaToUpdate);
        MangaToUpdate.makeAverage(scoresManga);
        MangaToUpdate.updateNbVotes(scoresManga);
        System.out.println(MangaToUpdate + " ///// " + MangaToUpdate.getId());
        mangaService.saveManga(MangaToUpdate);
        return ResponseEntity.ok(savedReview);
    }
}
