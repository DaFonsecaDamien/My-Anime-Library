package com.example.myanimelibrary.domain.service;

import com.example.myanimelibrary.domain.*;
import com.example.myanimelibrary.domain.repositories.StackRepository;
import com.example.myanimelibrary.infrastructure.exception.NameAlreadyTakenException;
import com.example.myanimelibrary.infrastructure.mapper.StackMapper;
import com.example.myanimelibrary.infrastructure.request.CopyStackRequest;
import com.example.myanimelibrary.infrastructure.request.CreateStackRequest;
import com.example.myanimelibrary.infrastructure.request.UpdateStackRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StackService {

    private final StackAnimeService stackAnimeService;
    private final StackMangaService stackMangaService;
    private final LibraryService libraryService;
    private final StackRepository stackRepository;
    private final AnimeService animeService;
    private final MangaService mangaService;


    public StackService(StackAnimeService stackAnimeService, StackMangaService stackMangaService, LibraryService libraryService, StackRepository stackRepository, AnimeService animeService, MangaService mangaService) {
        this.stackAnimeService = stackAnimeService;
        this.stackMangaService = stackMangaService;
        this.libraryService = libraryService;
        this.stackRepository = stackRepository;
        this.animeService = animeService;
        this.mangaService = mangaService;
    }

    public Stack createStack(CreateStackRequest request) {
        checkIfStackNameAlreadyTakenInUserLibrary(request.getName(), request.getUserId());
        Stack stackToSave = new Stack();
        stackToSave.setName(request.getName());
        stackToSave.setVisibility(request.getVisibility());
        stackToSave.setLibrary(libraryService.getLibraryByUserId(request.getUserId()));
        return stackRepository.saveStack(stackToSave);
    }

    public Stack saveStack(Stack stack) {
        return stackRepository.saveStack(stack);
    }


    public Stack getStackById(Long id) {
        return stackRepository.getStackById(id);
    }

    public Stack getLoadedStackById(Long id) {
        Stack stack = stackRepository.getStackById(id);
        stack = loadStackContent(stack);
        return stack;
    }

    public List<Stack> getAllStackFromLibraryId(Long libraryId) {
        Library library = libraryService.getLibraryById(libraryId);
        return stackRepository.getAllStackFromLibrary(library);
    }

    public StackAnime saveAnimeInStack(Long animeId, Long stackId) {
        checkIfAnimeAlreadyInStack(animeId, stackId);
        Anime anime = animeService.getAnimeById(animeId);
        Stack stack = getStackById(stackId);
        return stackAnimeService.saveAnimeInStack(stack, anime);
    }

    public StackManga saveMangaInStack(Long mangaId, Long stackId) {
        checkIfMangaAlreadyInStack(mangaId, stackId);
        Manga manga = mangaService.getMangaById(mangaId);
        Stack stack = getStackById(stackId);
        return stackMangaService.saveMangaInStack(stack, manga);
    }

    private void checkIfMangaAlreadyInStack(Long mangaId, Long stackId) {
        stackMangaService.checkIfMangaAlreadyInStack(mangaId, stackId);
    }

    private void checkIfAnimeAlreadyInStack(Long animeId, Long stackId) {
        stackAnimeService.checkIfAnimeAlreadyInStack(animeId, stackId);
    }

    public void deleteAnimeInStack(Long stackAnimeId) {
        stackAnimeService.deleteAnimeFromStackById(stackAnimeId);
    }

    public void deleteMangaInStack(Long stackMangaId) {
        stackMangaService.deleteMangaFromStackById(stackMangaId);
    }

    public void deleteStackById(Long stackId) {
        List<StackAnime> animesInStack = stackAnimeService.getAllAnimeInStackByStackId(stackId);
        // do for manga
        stackAnimeService.deleteAnimesFromStackById(animesInStack);
        stackRepository.deleteStackId(stackId);
    }

    public List<StackAnime> getAllAnimeInStack(Long stackId) {
        return stackAnimeService.getAllAnimeInStackByStackId(stackId);
    }

    public List<StackManga> getAllMangaInStack(Long stackId) {
        return stackMangaService.getAllMangaInStackByStackId(stackId);
    }

    public Stack updateStackById(UpdateStackRequest request) {
        Stack stackToUpdate = stackRepository.getStackById(request.getStackId());
        stackToUpdate = updateStackFactory(request, stackToUpdate);
        return saveStack(stackToUpdate);
    }

    public Stack loadStackContent(Stack stackToLoad) {
        stackToLoad.setAnimes(loadAnimeFromStack(stackToLoad));
        // load mangas
        return stackToLoad;
    }

    private List<Anime> loadAnimeFromStack(Stack stack) {
        List<StackAnime> stackAnimeList = stackAnimeService.getAllAnimeInStackByStackId(stack.getId());
        List<Anime> animeList = new ArrayList<>();
        for (StackAnime stackAnime : stackAnimeList) {
            animeList.add(stackAnime.getAnime());
        }
        return animeList;
    }

    private List<Manga> loadMangaFromStack(Stack stack) {
        List<StackManga> stackMangaList = stackMangaService.getAllMangaInStackByStackId(stack.getId());
        List<Manga> mangaList = new ArrayList<>();
        for (StackManga stackManga : stackMangaList) {
            mangaList.add(stackManga.getManga());
        }
        return mangaList;
    }

    private Stack updateStackFactory(UpdateStackRequest request, Stack stack) {
        if (request.getVisibility() != null) {
            stack.setVisibility(request.getVisibility());
        }
        if (request.getName() != null) {
            stack.setName(request.getName());
        }
        return stack;
    }

    public Stack copyStackByStackId(CopyStackRequest request) {
        Stack destStack = new Stack();
        List<Anime> animesInDestStack = new ArrayList<>();
        if (request.getCopyTargetStackId() == null) {
            checkIfStackNameAlreadyTakenInUserLibrary(request.getName(), request.getUserId());
            destStack.setName(request.getName());
            destStack.setLibrary(libraryService.getLibraryByUserId(request.getUserId()));
            destStack.setVisibility(request.getVisibility());
            destStack = stackRepository.saveStack(destStack);
        } else {
            destStack = stackRepository.getStackById(request.getCopyTargetStackId());
            animesInDestStack = loadStackContent(destStack).getAnimes();
        }
        Stack srcStack = stackRepository.getStackById(request.getSrcStackId());
        srcStack = loadStackContent(srcStack);
        List<Anime> animesToCopy = removeExistingAnimeInDestStack(srcStack.getAnimes(), destStack.getAnimes());
        // do the same for manga
        List<StackAnime> animesCopied = stackAnimeService.saveAnimesInStack(animesToCopy, destStack);
        // copy mangas

        return destStack;
    }

    private List<Anime> removeExistingAnimeInDestStack(List<Anime> animeFromSrcStack, List<Anime> animeFromDestStack) {
        List<Anime> filteredAnimes = new ArrayList<>();
        for (Anime animeInSrcStack : animeFromSrcStack) {
            for (Anime animeInDestStack : animeFromDestStack) {
                if (!Objects.equals(animeInDestStack.getId(), animeInSrcStack.getId())) {
                    filteredAnimes.add(animeInSrcStack);
                }
            }
        }
        return filteredAnimes;
    }

    private List<Manga> removeExistingMangaInDestStack(List<Manga> mangaFromSrcStack, List<Manga> mangaFromDestStack) {
        List<Manga> filteredManga = new ArrayList<>();
        for (Manga mangaInSrcStack : mangaFromSrcStack) {
            for (Manga mangaInDestStack : mangaFromDestStack) {
                if (!Objects.equals(mangaInDestStack.getId(), mangaInSrcStack.getId())) {
                    filteredManga.add(mangaInSrcStack);
                }
            }
        }
        return filteredManga;
    }

    private void checkIfStackNameAlreadyTakenInUserLibrary(String name, Long userId) {
        Library library = libraryService.getLibraryByUserId(userId);
        if (stackRepository.existStackWithNameInLibrary(name, library.getId())) {
            throw new NameAlreadyTakenException("Name already Taken");
        }
    }
}
