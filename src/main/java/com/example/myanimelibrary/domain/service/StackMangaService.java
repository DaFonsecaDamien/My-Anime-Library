package com.example.myanimelibrary.domain.service;

import com.example.myanimelibrary.domain.Manga;
import com.example.myanimelibrary.domain.Stack;
import com.example.myanimelibrary.domain.StackManga;
import com.example.myanimelibrary.domain.repositories.StackMangaRepository;
import com.example.myanimelibrary.infrastructure.exception.MangaAlreadyInStackException;

import java.util.ArrayList;
import java.util.List;

public class StackMangaService {
    private final StackMangaRepository stackMangaRepository;

    public StackMangaService(StackMangaRepository stackMangaRepository) {
        this.stackMangaRepository = stackMangaRepository;
    }

    public StackManga saveMangaInStack(Stack stack, Manga Manga) {
        StackManga MangaInStack = new StackManga();
        MangaInStack.setManga(Manga);
        MangaInStack.setStack(stack);
        return stackMangaRepository.saveStackManga(MangaInStack);
    }

    public List<StackManga> saveMangasInStack(List<Manga> Mangas, Stack stack) {
        List<StackManga> MangasSaved = new ArrayList<>();
        for (Manga Manga : Mangas) {
            MangasSaved.add(saveMangaInStack(stack, Manga));
        }
        return MangasSaved;
    }

    public List<StackManga> getAllMangaInStackByStackId(Long stackId) {
        return stackMangaRepository.getAllMangaFromStackId(stackId);
    }

    public void deleteMangaFromStackById(Long stackMangaId) {
        stackMangaRepository.deleteStackMangaById(stackMangaId);
    }

    public void deleteMangasFromStackById(List<StackManga> stackMangaList) {
        for (StackManga stackManga : stackMangaList) {
            deleteMangaFromStackById(stackManga.getId());
        }
    }

    public void checkIfMangaAlreadyInStack(Long MangaId, Long stackId) {
        if (stackMangaRepository.existMangaInStack(MangaId, stackId)) {
            throw new MangaAlreadyInStackException("Manga already in stack");
        }
    }
}
