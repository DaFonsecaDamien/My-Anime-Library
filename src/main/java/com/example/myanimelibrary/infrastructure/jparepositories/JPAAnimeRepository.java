package com.example.myanimelibrary.infrastructure.jparepositories;

import com.example.myanimelibrary.infrastructure.entities.AnimeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAAnimeRepository extends JpaRepository<AnimeEntity, Long>, JpaSpecificationExecutor<AnimeEntity> {

    AnimeEntity findByTitlesContains(String title);

    AnimeEntity getAnimeEntityById(Long id);

    boolean existsAnimeEntityByTitlesContaining(String title);

    @Override
    List<AnimeEntity> findAll(Specification<AnimeEntity> spec);

    List<AnimeEntity> getAnimeEntityByIdAndYear(Long id, int year);
}
