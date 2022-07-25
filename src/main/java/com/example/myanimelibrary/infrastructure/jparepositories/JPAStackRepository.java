package com.example.myanimelibrary.infrastructure.jparepositories;

import com.example.myanimelibrary.infrastructure.entities.LibraryEntity;
import com.example.myanimelibrary.infrastructure.entities.StackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAStackRepository extends JpaRepository<StackEntity, Long> {

    List<StackEntity> findAllByLibrary(LibraryEntity libraryEntity);

    List<StackEntity> findAllByNameLike(String name);

    boolean existsStackEntityByNameEqualsAndAndLibrary_Id(String name, Long libraryId);
}
