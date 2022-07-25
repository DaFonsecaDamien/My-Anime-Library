package com.example.myanimelibrary.infrastructure.jparepositories;

import com.example.myanimelibrary.infrastructure.entities.StackMangaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAStackMangaRepository extends JpaRepository<StackMangaEntity, Long> {
    List<StackMangaEntity> findAllByStackEntityId(Long stackId);

    boolean existsStackMangaEntityByMangaEntity_IdAndStackEntity_Id(Long mangaId, Long stackId);
}
