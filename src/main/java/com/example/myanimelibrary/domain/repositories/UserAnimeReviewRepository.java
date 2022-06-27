package com.example.myanimelibrary.domain.repositories;

import com.example.myanimelibrary.domain.UserAnimeReview;
import com.example.myanimelibrary.infrastructure.entities.AnimeEntity;
import com.example.myanimelibrary.infrastructure.entities.UserAnimeReviewEntity;
import com.example.myanimelibrary.infrastructure.request.CreateUserAnimeReviewRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAnimeReviewRepository {

    void saveUserAnimeReview(UserAnimeReview review);

    UserAnimeReview getUserReviewAnimeEntityById(String id);

    void deleteUserAnimeReviewById(String id);

    List<UserAnimeReviewEntity> getUserReviewAnimeEntityByAnime(AnimeEntity anime);


}
