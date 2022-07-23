package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.Manga;
import com.example.myanimelibrary.domain.UserMangaReview;
import com.example.myanimelibrary.domain.repositories.UserMangaReviewRepository;
import com.example.myanimelibrary.infrastructure.entities.UserMangaReviewEntity;
import com.example.myanimelibrary.infrastructure.jparepositories.JPAUserMangaReviewRepository;
import com.example.myanimelibrary.infrastructure.mapper.MangaMapper;
import com.example.myanimelibrary.infrastructure.mapper.UserMangaReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMangaReviewRepositoryInfra implements UserMangaReviewRepository {
    private final JPAUserMangaReviewRepository jpaUserMangaReviewRepository;
    private final UserMangaReviewMapper userMangaReviewMapper;
    private final MangaMapper mangaMapper;

    @Autowired
    public UserMangaReviewRepositoryInfra(JPAUserMangaReviewRepository jpaUserMangaReviewRepository, UserMangaReviewMapper userMangaReviewMapper, MangaMapper mangaMapper) {
        this.jpaUserMangaReviewRepository = jpaUserMangaReviewRepository;
        this.userMangaReviewMapper = userMangaReviewMapper;
        this.mangaMapper = mangaMapper;
    }

    @Override
    public UserMangaReview saveUserMangaReview(UserMangaReview review) {
        UserMangaReviewEntity savedReview = jpaUserMangaReviewRepository.save(userMangaReviewMapper.FromModelToEntity(review));
        return userMangaReviewMapper.FromEntityToModel(savedReview);
    }

    @Override
    public UserMangaReview getUserReviewMangaEntityById(Long id) {
        return userMangaReviewMapper.FromEntityToModel(jpaUserMangaReviewRepository.getById(id));
    }

    @Override
    public void deleteUserMangaReviewById(Long id) {
        jpaUserMangaReviewRepository.deleteById(id);
    }

    @Override
    public List<UserMangaReview> getUserReviewMangaEntityByManga(Manga manga) {
        List<UserMangaReviewEntity> userMangaReviewEntities = jpaUserMangaReviewRepository.getAllByMangaEntity(mangaMapper.FromModelToEntity(manga));
        return userMangaReviewEntities.stream().map(userMangaReviewMapper::FromEntityToModel).collect(Collectors.toList());
    }

    @Override
    public List<UserMangaReview> getAllUserMangaReviewByUserId(Long userId) {
        List<UserMangaReviewEntity> userMangaReviewEntities = jpaUserMangaReviewRepository.getAllByUserEntityId(userId);
        return userMangaReviewEntities.stream().map(userMangaReviewMapper::FromEntityToModel).collect(Collectors.toList());
    }
}
