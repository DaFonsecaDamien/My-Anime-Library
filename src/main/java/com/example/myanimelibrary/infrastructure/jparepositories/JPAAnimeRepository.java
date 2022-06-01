package com.example.myanimelibrary.infrastructure.jparepositories;

import com.example.myanimelibrary.infrastructure.entities.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAAnimeRepository extends JpaRepository<Anime, String> {


}
