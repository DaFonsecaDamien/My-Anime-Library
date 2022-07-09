package com.example.myanimelibrary.domain.repositories;

import com.example.myanimelibrary.domain.Stack;
import com.example.myanimelibrary.domain.StackManga;

import java.util.List;

public interface StackMangaRepository {

    StackManga saveStackAnime(StackManga stackManga);

    void deleteStackManga(StackManga stackManga);

    List<StackManga> getAllMangaFromStack(Stack stack);

}
