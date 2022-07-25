package com.example.myanimelibrary.domain.repositories;

import com.example.myanimelibrary.domain.Manga;
import com.example.myanimelibrary.domain.UserMangaReview;

import java.util.List;

public interface UserMangaReviewRepository {

    UserMangaReview saveUserMangaReview(UserMangaReview review);

    UserMangaReview getUserReviewMangaEntityById(Long id);

    void deleteUserMangaReviewById(Long id);

    List<UserMangaReview> getUserReviewMangaEntityByManga(Manga manga);

    List<UserMangaReview> getAllUserMangaReviewByUserId(Long userId);

}
