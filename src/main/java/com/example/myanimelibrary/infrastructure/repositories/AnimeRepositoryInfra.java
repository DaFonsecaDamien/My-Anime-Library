package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.repositories.AnimeRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AnimeRepositoryInfra implements AnimeRepository {
}
