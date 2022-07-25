package com.example.myanimelibrary.infrastructure.mapper;

import com.example.myanimelibrary.TMP.user.Constants;
import com.example.myanimelibrary.domain.UserAnimeReview;
import com.example.myanimelibrary.infrastructure.entities.UserAnimeReviewEntity;
import com.example.myanimelibrary.infrastructure.request.CreateUserAnimeReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAnimeReviewMapper {

    private final AnimeMapper animeMapper;

    @Autowired
    public UserAnimeReviewMapper(AnimeMapper animeMapper) {
        this.animeMapper = animeMapper;
    }


    public UserAnimeReview FromEntityToModel(UserAnimeReviewEntity userAnimeReviewEntity) {
        return new UserAnimeReview(
                userAnimeReviewEntity.getId(),
                animeMapper.FromEntityToModel(userAnimeReviewEntity.getAnimeEntity()),
                Constants.fakeUser,
                userAnimeReviewEntity.getCurrentEpisode(),
                userAnimeReviewEntity.getScore(),
                userAnimeReviewEntity.getComment(),
                userAnimeReviewEntity.getAnimeSiteUri()
        );
    }

    public UserAnimeReviewEntity FromModelToEntity(UserAnimeReview userAnimeReview) {
        return new UserAnimeReviewEntity(
                userAnimeReview.getId(),
                animeMapper.FromModelToEntity(userAnimeReview.getAnime()),
                Constants.fakeUserEntity,
                userAnimeReview.getCurrentEpisode(),
                userAnimeReview.getScore(),
                userAnimeReview.getComment(),
                userAnimeReview.getAnimeSiteUri()
        );
    }

    public UserAnimeReview FromRequestToModel(CreateUserAnimeReviewRequest request) {
        return new UserAnimeReview(
                null,
                request.getAnime(),
                Constants.fakeUser,
                request.getCurrentEpisode(),
                request.getScore(),
                request.getComment(),
                request.getAnimeSiteUri()
        );
    }
}
