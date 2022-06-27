package com.example.myanimelibrary.domain.service;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.UserAnimeReview;
import com.example.myanimelibrary.domain.repositories.AnimeRepository;
import com.example.myanimelibrary.domain.repositories.UserAnimeReviewRepository;
import com.example.myanimelibrary.infrastructure.entities.AnimeEntity;
import com.example.myanimelibrary.infrastructure.entities.UserAnimeReviewEntity;
import com.example.myanimelibrary.infrastructure.mapper.AnimeMapper;
import com.example.myanimelibrary.infrastructure.mapper.UserAnimeReviewMapper;
import com.example.myanimelibrary.infrastructure.request.CreateUserAnimeReviewRequest;
import com.example.myanimelibrary.infrastructure.request.UpdateUserAnimeReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAnimeReviewService {

    private final UserAnimeReviewRepository userAnimeReviewRepository;
    private final AnimeRepository animeRepository;
    private final UserAnimeReviewMapper userAnimeReviewMapper;
    private final AnimeMapper animeMapper;

    @Autowired
    public UserAnimeReviewService(UserAnimeReviewRepository userAnimeReviewRepository, AnimeRepository animeRepository, UserAnimeReviewMapper userAnimeReviewMapper, AnimeMapper animeMapper) {
        this.userAnimeReviewRepository = userAnimeReviewRepository;
        this.animeRepository = animeRepository;
        this.userAnimeReviewMapper = userAnimeReviewMapper;
        this.animeMapper = animeMapper;
    }

    public void createAnimeReview(String id, CreateUserAnimeReviewRequest request){
        AnimeEntity anime = animeRepository.getAnimeById(id);
        request.setAnime(animeMapper.FromEntityToModel(anime));
        userAnimeReviewRepository.saveUserAnimeReview(userAnimeReviewMapper.FromRequestToModel(request));
    }

    public void updateAnimeReview(String id, UpdateUserAnimeReviewRequest request){
        UserAnimeReview review = userAnimeReviewRepository.getUserReviewAnimeEntityById(id);
        review.setAnimeSiteUri(request.getAnimeSiteUri());
        review.setComment(request.getComment());
        review.setCurrentEpisode(request.getCurrentEpisode());
        review.setScore(request.getScore());
        userAnimeReviewRepository.saveUserAnimeReview(review);
    }

    public UserAnimeReview getById(String id){
        return userAnimeReviewRepository.getUserReviewAnimeEntityById(id);
    }

    public void deleteById(String id){
        userAnimeReviewRepository.deleteUserAnimeReviewById(id);
    }

    public List<UserAnimeReview> getAllByAnimeId(String animeId){
        Anime anime = animeMapper.FromEntityToModel(animeRepository.getAnimeById(animeId));
        List<UserAnimeReviewEntity> userAnimeReviewEntities = userAnimeReviewRepository
                .getUserReviewAnimeEntityByAnime(animeMapper.FromModelToEntity(anime));
        return userAnimeReviewEntities
                .stream()
                .map(userAnimeReviewMapper::FromEntityToModel)
                .collect(Collectors.toList());
    }
}
