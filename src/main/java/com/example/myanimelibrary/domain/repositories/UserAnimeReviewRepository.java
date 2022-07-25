package com.example.myanimelibrary.domain.repositories;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.UserAnimeReview;

import java.util.List;

public interface UserAnimeReviewRepository {

    UserAnimeReview saveUserAnimeReview(UserAnimeReview review);

    UserAnimeReview getUserReviewAnimeEntityById(Long id);

    void deleteUserAnimeReviewById(Long id);

    List<UserAnimeReview> getUserReviewAnimeEntityByAnime(Anime anime);

    List<UserAnimeReview> getAllUserAnimeReviewByUserId(Long userId);

}
