package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.UserAnimeReview;
import com.example.myanimelibrary.domain.repositories.UserAnimeReviewRepository;
import com.example.myanimelibrary.infrastructure.entities.UserAnimeReviewEntity;
import com.example.myanimelibrary.infrastructure.jparepositories.JPAUserAnimeReviewRepository;
import com.example.myanimelibrary.infrastructure.mapper.AnimeMapper;
import com.example.myanimelibrary.infrastructure.mapper.UserAnimeReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


@Repository
@Primary
public class UserAnimeReviewRepositoryInfra implements UserAnimeReviewRepository {

    private final JPAUserAnimeReviewRepository jpaUserAnimeReviewRepository;
    private final UserAnimeReviewMapper userAnimeReviewMapper;
    private final AnimeMapper animeMapper;

    @Autowired
    public UserAnimeReviewRepositoryInfra(JPAUserAnimeReviewRepository jpaUserAnimeReviewRepository, UserAnimeReviewMapper userAnimeReviewMapper, AnimeMapper animeMapper) {
        this.jpaUserAnimeReviewRepository = jpaUserAnimeReviewRepository;
        this.userAnimeReviewMapper = userAnimeReviewMapper;
        this.animeMapper = animeMapper;
    }

    @Override
    public UserAnimeReview saveUserAnimeReview(UserAnimeReview review) {
        UserAnimeReviewEntity savedReview = jpaUserAnimeReviewRepository.save(userAnimeReviewMapper.FromModelToEntity(review));
        return userAnimeReviewMapper.FromEntityToModel(savedReview);
    }

    @Override
    public UserAnimeReview getUserReviewAnimeEntityById(Long id) {
        return userAnimeReviewMapper.FromEntityToModel(jpaUserAnimeReviewRepository.getById(id));
    }

    @Override
    public void deleteUserAnimeReviewById(Long id) {
        jpaUserAnimeReviewRepository.deleteById(id);
    }

    @Override
    public List<UserAnimeReview> getUserReviewAnimeEntityByAnime(Anime anime) {
        List<UserAnimeReviewEntity> userAnimeReviewEntities = jpaUserAnimeReviewRepository.getAllByAnimeEntity(animeMapper.FromModelToEntity(anime));
        return userAnimeReviewEntities.stream().map(userAnimeReviewMapper::FromEntityToModel).collect(Collectors.toList());
    }

    @Override
    public List<UserAnimeReview> getAllUserAnimeReviewByUserId(Long userId) {
        List<UserAnimeReviewEntity> userAnimeReviewEntities = jpaUserAnimeReviewRepository.getAllByUserEntityId(userId);
        return userAnimeReviewEntities.stream().map(userAnimeReviewMapper::FromEntityToModel).collect(Collectors.toList());
    }


}
