package com.example.myanimelibrary.infrastructure.jparepositories;

import com.example.myanimelibrary.infrastructure.entities.StackAnimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAStackAnimeRepository extends JpaRepository<StackAnimeEntity, Long> {

    List<StackAnimeEntity> findAllByStackEntityId(Long stackId);

    boolean existsStackAnimeEntityByAnimeEntity_IdAndStackEntity_Id(Long animeId, Long stackId);
}
