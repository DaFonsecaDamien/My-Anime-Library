package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.Stack;
import com.example.myanimelibrary.domain.StackManga;
import com.example.myanimelibrary.domain.repositories.StackMangaRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class StackMangaRepositoryInfra implements StackMangaRepository {

    @Override
    public StackManga saveStackAnime(StackManga stackManga) {
        return null;
    }

    @Override
    public void deleteStackManga(StackManga stackManga) {

    }

    @Override
    public List<StackManga> getAllMangaFromStack(Stack stack) {
        return null;
    }
}
