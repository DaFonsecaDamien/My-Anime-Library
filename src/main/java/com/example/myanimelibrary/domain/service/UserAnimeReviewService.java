package com.example.myanimelibrary.domain.service;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.UserAnimeReview;
import com.example.myanimelibrary.domain.repositories.AnimeRepository;
import com.example.myanimelibrary.domain.repositories.UserAnimeReviewRepository;
import com.example.myanimelibrary.infrastructure.mapper.UserAnimeReviewMapper;
import com.example.myanimelibrary.infrastructure.request.CreateUserAnimeReviewRequest;
import com.example.myanimelibrary.infrastructure.request.UpdateUserAnimeReviewRequest;

import java.util.List;

public class UserAnimeReviewService {

    private final UserAnimeReviewRepository userAnimeReviewRepository;
    private final AnimeService animeService;
    private final AnimeRepository animeRepository;
    private final UserAnimeReviewMapper userAnimeReviewMapper;

    public UserAnimeReviewService(UserAnimeReviewRepository userAnimeReviewRepository, AnimeService animeService, AnimeRepository animeRepository, UserAnimeReviewMapper userAnimeReviewMapper) {
        this.userAnimeReviewRepository = userAnimeReviewRepository;
        this.animeService = animeService;
        this.animeRepository = animeRepository;
        this.userAnimeReviewMapper = userAnimeReviewMapper;
    }

    public UserAnimeReview createAnimeReview(Long id, CreateUserAnimeReviewRequest request){
        Anime anime = animeRepository.getAnimeById(id);
        request.setAnime(anime);
        return userAnimeReviewRepository.saveUserAnimeReview(userAnimeReviewMapper.FromRequestToModel(request));
    }

    public void updateAnimeReview(Long id, UpdateUserAnimeReviewRequest request){
        UserAnimeReview review = userAnimeReviewRepository.getUserReviewAnimeEntityById(id);
        review.setAnimeSiteUri(request.getAnimeSiteUri());
        review.setComment(request.getComment());
        review.setCurrentEpisode(request.getCurrentEpisode());
        review.setScore(request.getScore());
        userAnimeReviewRepository.saveUserAnimeReview(review);
    }

    public UserAnimeReview getById(Long id){
        return userAnimeReviewRepository.getUserReviewAnimeEntityById(id);
    }

    public void deleteById(Long id){
        userAnimeReviewRepository.deleteUserAnimeReviewById(id);
    }

    public List<UserAnimeReview> getAllByAnimeId(Long animeId){
        Anime anime = animeService.getAnimeById(animeId);
        return userAnimeReviewRepository
                .getUserReviewAnimeEntityByAnime(anime);
    }

    public List<UserAnimeReview> getAllAnimeReviewByUserId(Long userId){
        return userAnimeReviewRepository.getAllUserAnimeReviewByUserId(userId);
    }

    public List<UserAnimeReview> getAllUserAnimeReviewByAnimeId(Long animeId){
        Anime anime = animeService.getAnimeById(animeId);
        return userAnimeReviewRepository.getUserReviewAnimeEntityByAnime(anime);
    }


}
