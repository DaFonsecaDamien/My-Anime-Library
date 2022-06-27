package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.UserAnimeReview;
import com.example.myanimelibrary.domain.repositories.UserAnimeReviewRepository;
import com.example.myanimelibrary.infrastructure.entities.AnimeEntity;
import com.example.myanimelibrary.infrastructure.entities.UserAnimeReviewEntity;
import com.example.myanimelibrary.infrastructure.jparepositories.JPAUserAnimeReviewRepository;
import com.example.myanimelibrary.infrastructure.mapper.UserAnimeReviewMapper;
import com.example.myanimelibrary.infrastructure.request.CreateUserAnimeReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Primary
public class UserAnimeReviewRepositoryInfra implements UserAnimeReviewRepository {

    private final JPAUserAnimeReviewRepository jpaUserAnimeReviewRepository;
    private final UserAnimeReviewMapper userAnimeReviewMapper;

    @Autowired
    public UserAnimeReviewRepositoryInfra(JPAUserAnimeReviewRepository jpaUserAnimeReviewRepository, UserAnimeReviewMapper userAnimeReviewMapper) {
        this.jpaUserAnimeReviewRepository = jpaUserAnimeReviewRepository;
        this.userAnimeReviewMapper = userAnimeReviewMapper;
    }

    @Override
    public void saveUserAnimeReview(UserAnimeReview review) {
        jpaUserAnimeReviewRepository.save(userAnimeReviewMapper.FromModelToEntity(review));
    }

    @Override
    public UserAnimeReview getUserReviewAnimeEntityById(String id) {
        return userAnimeReviewMapper.FromEntityToModel(jpaUserAnimeReviewRepository.getById(id));
    }

    @Override
    public void deleteUserAnimeReviewById(String id) {
        jpaUserAnimeReviewRepository.deleteById(id);
    }

    @Override
    public List<UserAnimeReviewEntity> getUserReviewAnimeEntityByAnime(AnimeEntity animeEntity) {
        return jpaUserAnimeReviewRepository.getAllByAnimeEntity(animeEntity);
    }
}
