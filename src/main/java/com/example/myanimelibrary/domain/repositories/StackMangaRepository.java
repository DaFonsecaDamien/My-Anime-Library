package com.example.myanimelibrary.domain.repositories;

import com.example.myanimelibrary.domain.StackManga;

import java.util.List;

public interface StackMangaRepository {

    StackManga saveStackManga(StackManga stackManga);

    void deleteStackMangaById(Long stackMangaId);

    List<StackManga> getAllMangaFromStackId(Long stackId);

    StackManga getStackMangaById(Long id);

    boolean existMangaInStack(Long mangaId, Long stackId);
}
