package com.example.myanimelibrary.infrastructure.jparepositories;

import com.example.myanimelibrary.infrastructure.entities.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPALibraryRepository extends JpaRepository<LibraryEntity, Long> {

    LibraryEntity getLibraryEntityByUserEntity_Id(Long userId);
}
