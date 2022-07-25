package com.example.myanimelibrary.domain.service;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.Stack;
import com.example.myanimelibrary.domain.StackAnime;
import com.example.myanimelibrary.domain.repositories.StackAnimeRepository;
import com.example.myanimelibrary.infrastructure.exception.AnimeAlreadyInStackException;

import java.util.ArrayList;
import java.util.List;

public class StackAnimeService {

    private final StackAnimeRepository stackAnimeRepository;

    public StackAnimeService(StackAnimeRepository stackAnimeRepository) {
        this.stackAnimeRepository = stackAnimeRepository;
    }

    public StackAnime saveAnimeInStack(Stack stack, Anime anime) {
        StackAnime animeInStack = new StackAnime();
        animeInStack.setAnime(anime);
        animeInStack.setStack(stack);
        return stackAnimeRepository.saveStackAnime(animeInStack);
    }

    public List<StackAnime> saveAnimesInStack(List<Anime> animes, Stack stack) {
        List<StackAnime> animesSaved = new ArrayList<>();
        for (Anime anime : animes) {
            animesSaved.add(saveAnimeInStack(stack, anime));
        }
        return animesSaved;
    }

    public List<StackAnime> getAllAnimeInStackByStackId(Long stackId) {
        return stackAnimeRepository.getAllAnimeFromStackId(stackId);
    }

    public void deleteAnimeFromStackById(Long stackAnimeId) {
        stackAnimeRepository.deleteStackAnimeById(stackAnimeId);
    }

    public void deleteAnimesFromStackById(List<StackAnime> stackAnimeList) {
        for (StackAnime stackAnime : stackAnimeList) {
            deleteAnimeFromStackById(stackAnime.getId());
        }
    }

    public void checkIfAnimeAlreadyInStack(Long animeId, Long stackId) {
        if (stackAnimeRepository.existAnimeInStack(animeId, stackId)) {
            throw new AnimeAlreadyInStackException("Anime already in stack");
        }
    }
}
