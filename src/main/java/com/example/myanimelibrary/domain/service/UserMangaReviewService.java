package com.example.myanimelibrary.domain.service;

import com.example.myanimelibrary.domain.Manga;
import com.example.myanimelibrary.domain.UserMangaReview;
import com.example.myanimelibrary.domain.repositories.MangaRepository;
import com.example.myanimelibrary.domain.repositories.UserMangaReviewRepository;
import com.example.myanimelibrary.infrastructure.mapper.UserMangaReviewMapper;
import com.example.myanimelibrary.infrastructure.request.CreateUserMangaReviewRequest;
import com.example.myanimelibrary.infrastructure.request.UpdateUserMangaReviewRequest;

import java.util.List;

public class UserMangaReviewService {
    private final UserMangaReviewRepository userMangaReviewRepository;
    private final MangaService mangaService;
    private final MangaRepository mangaRepository;
    private final UserMangaReviewMapper userMangaReviewMapper;

    public UserMangaReviewService(UserMangaReviewRepository userMangaReviewRepository, MangaService mangaService, MangaRepository mangaRepository, UserMangaReviewMapper userMangaReviewMapper) {
        this.userMangaReviewRepository = userMangaReviewRepository;
        this.mangaService = mangaService;
        this.mangaRepository = mangaRepository;
        this.userMangaReviewMapper = userMangaReviewMapper;
    }

    public UserMangaReview createMangaReview(Long id, CreateUserMangaReviewRequest request) {
        Manga manga = mangaRepository.getMangaById(id);
        request.setManga(manga);
        return userMangaReviewRepository.saveUserMangaReview(userMangaReviewMapper.FromRequestToModel(request));
    }

    public void updateMangaReview(Long id, UpdateUserMangaReviewRequest request) {
        UserMangaReview review = userMangaReviewRepository.getUserReviewMangaEntityById(id);
        review.setReadSiteUri(request.getMangaSiteUri());
        review.setComment(request.getComment());
        review.setCurrentChapter(request.getCurrentChapter());
        review.setScore(request.getScore());
        userMangaReviewRepository.saveUserMangaReview(review);
    }

    public UserMangaReview getById(Long id) {
        return userMangaReviewRepository.getUserReviewMangaEntityById(id);
    }

    public void deleteById(Long id) {
        userMangaReviewRepository.deleteUserMangaReviewById(id);
    }

    public List<UserMangaReview> getAllByMangaId(Long mangaId) {
        Manga manga = mangaService.getMangaById(mangaId);
        return userMangaReviewRepository
                .getUserReviewMangaEntityByManga(manga);
    }

    public List<UserMangaReview> getAllMangaReviewByUserId(Long userId) {
        return userMangaReviewRepository.getAllUserMangaReviewByUserId(userId);
    }

    public List<UserMangaReview> getAllUserMangaReviewByMangaId(Long mangaId) {
        Manga manga = mangaService.getMangaById(mangaId);
        return userMangaReviewRepository.getUserReviewMangaEntityByManga(manga);
    }
}
