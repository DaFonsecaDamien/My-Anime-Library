package com.example.myanimelibrary.infrastructure.mapper;

import com.example.myanimelibrary.TMP.user.Constants;
import com.example.myanimelibrary.domain.UserMangaReview;
import com.example.myanimelibrary.infrastructure.entities.UserMangaReviewEntity;
import com.example.myanimelibrary.infrastructure.request.CreateUserMangaReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMangaReviewMapper {
    private final MangaMapper mangaMapper;

    @Autowired
    public UserMangaReviewMapper(MangaMapper mangaMapper) {
        this.mangaMapper = mangaMapper;
    }


    public UserMangaReview FromEntityToModel(UserMangaReviewEntity userMangaReviewEntity) {
        return new UserMangaReview(
                userMangaReviewEntity.getId(),
                mangaMapper.FromEntityToModel(userMangaReviewEntity.getMangaEntity()),
                Constants.fakeUser,
                userMangaReviewEntity.getCurrentChapter(),
                userMangaReviewEntity.getScore(),
                userMangaReviewEntity.getComment(),
                userMangaReviewEntity.getMangaSiteUri()
        );
    }

    public UserMangaReviewEntity FromModelToEntity(UserMangaReview userMangaReview) {
        return new UserMangaReviewEntity(
                mangaMapper.FromModelToEntity(userMangaReview.getManga()),
                Constants.fakeUserEntity,
                userMangaReview.getCurrentChapter(),
                userMangaReview.getScore(),
                userMangaReview.getComment(),
                userMangaReview.getReadSiteUri()
        );
    }

    public UserMangaReview FromRequestToModel(CreateUserMangaReviewRequest request) {
        return new UserMangaReview(
                null,
                request.getManga(),
                Constants.fakeUser,
                request.getCurrentChapter(),
                request.getScore(),
                request.getComment(),
                request.getMangaSiteUri()
        );
    }
}
