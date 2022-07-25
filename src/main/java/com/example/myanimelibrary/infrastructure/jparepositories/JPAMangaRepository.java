package com.example.myanimelibrary.infrastructure.jparepositories;

import com.example.myanimelibrary.infrastructure.entities.MangaEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JPAMangaRepository extends JpaRepository<MangaEntity, Long>, JpaSpecificationExecutor<MangaEntity> {
    MangaEntity findByTitlesContains(String title);

    MangaEntity getMangaEntityById(Long id);

    boolean existsMangaEntityByTitlesContaining(String title);

    @Override
    List<MangaEntity> findAll(Specification<MangaEntity> spec);

    List<MangaEntity> getMangaEntityByIdAndStartDate(Long id, LocalDate date);
}
