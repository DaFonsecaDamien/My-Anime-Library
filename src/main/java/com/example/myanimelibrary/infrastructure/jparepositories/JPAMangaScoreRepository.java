package com.example.myanimelibrary.infrastructure.jparepositories;

import com.example.myanimelibrary.infrastructure.entities.MangaEntity;
import com.example.myanimelibrary.infrastructure.entities.MangaScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPAMangaScoreRepository extends JpaRepository<MangaScoreEntity, Long> {

    MangaScoreEntity getByMangaEntityAndValue(MangaEntity mangaEntity, Integer value);

    List<MangaScoreEntity> getAllByMangaEntity(MangaEntity mangaEntity);
}
