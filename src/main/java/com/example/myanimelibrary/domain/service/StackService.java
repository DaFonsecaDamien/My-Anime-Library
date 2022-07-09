package com.example.myanimelibrary.domain.service;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.Library;
import com.example.myanimelibrary.domain.Stack;
import com.example.myanimelibrary.domain.StackAnime;
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
    private final LibraryService libraryService;
    private final StackRepository stackRepository;
    private final StackMapper stackMapper;
    private final AnimeService animeService;

    public StackService(StackAnimeService stackAnimeService, LibraryService libraryService, StackRepository stackRepository, StackMapper stackMapper, AnimeService animeService) {
        this.stackAnimeService = stackAnimeService;
        this.libraryService = libraryService;
        this.stackRepository = stackRepository;
        this.stackMapper = stackMapper;
        this.animeService = animeService;
    }

    public Stack createStack(CreateStackRequest request){
        checkIfStackNameAlreadyTakenInUserLibrary(request.getName(), request.getUserId());
        Stack stackToSave = new Stack();
        stackToSave.setName(request.getName());
        stackToSave.setVisibility(request.getVisibility());
        stackToSave.setLibrary(libraryService.getLibraryByUserId(request.getUserId()));
        return stackRepository.saveStack(stackToSave);
    }

    public Stack saveStack(Stack stack){
        return stackRepository.saveStack(stack);
    }


    public Stack getStackById(Long id){
        return stackRepository.getStackById(id);
    }

    public Stack getLoadedStackById(Long id){
        Stack stack = stackRepository.getStackById(id);
        stack = loadStackContent(stack);
        return stack;
    }

    public List<Stack> getAllStackFromLibraryId(Long libraryId){
        Library library = libraryService.getLibraryById(libraryId);
        return stackRepository.getAllStackFromLibrary(library);
    }

    public StackAnime saveAnimeInStack(Long animeId, Long stackId){
        checkIfAnimeAlreadyInStack(animeId, stackId);
        Anime anime = animeService.getAnimeById(animeId);
        Stack stack = getStackById(stackId);
        return stackAnimeService.saveAnimeInStack(stack, anime);
    }

    private void checkIfAnimeAlreadyInStack(Long animeId, Long stackId){
        stackAnimeService.checkIfAnimeAlreadyInStack(animeId, stackId);
    }

    public void deleteAnimeInStack(Long stackAnimeId){
        stackAnimeService.deleteAnimeFromStackById(stackAnimeId);
    }

    public void deleteStackById(Long stackId){
        List<StackAnime> animesInStack = stackAnimeService.getAllAnimeInStackByStackId(stackId);
        // do for manga
        stackAnimeService.deleteAnimesFromStackById(animesInStack);
        stackRepository.deleteStackId(stackId);
    }

    public List<StackAnime> getAllAnimeInStack(Long stackId){
        return stackAnimeService.getAllAnimeInStackByStackId(stackId);
    }

    public Stack updateStackById(UpdateStackRequest request){
        Stack stackToUpdate = stackRepository.getStackById(request.getStackId());
        stackToUpdate = updateStackFactory(request, stackToUpdate);
        return saveStack(stackToUpdate);
    }

    public Stack loadStackContent(Stack stackToLoad){
        stackToLoad.setAnimes(loadAnimeFromStack(stackToLoad));
        // load mangas
        return stackToLoad;
    }

    private List<Anime> loadAnimeFromStack(Stack stack){
        List<StackAnime> stackAnimeList = stackAnimeService.getAllAnimeInStackByStackId(stack.getId());
        List<Anime> animeList = new ArrayList<>();
        for( StackAnime stackAnime : stackAnimeList){
            animeList.add(stackAnime.getAnime());
        }
        return  animeList;
    }

    private Stack updateStackFactory(UpdateStackRequest request, Stack stack){
        if (request.getVisibility() != null){
            stack.setVisibility(request.getVisibility());
        }
        if( request.getName() != null){
            stack.setName(request.getName());
        }
        return stack;
    }

    public Stack copyStackByStackId(CopyStackRequest request) {
        Stack destStack = new Stack();
        List<Anime> animesInDestStack = new ArrayList<>();
        if( request.getCopyTargetStackId() == null){
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

    private List<Anime> removeExistingAnimeInDestStack(List<Anime> animeFromSrcStack, List<Anime> animeFromDestStack){
        List<Anime> filteredAnimes = new ArrayList<>();
        for (Anime animeInSrcStack : animeFromSrcStack){
            for (Anime animeInDestStack : animeFromDestStack){
                if(!Objects.equals(animeInDestStack.getId(), animeInSrcStack.getId())){
                    filteredAnimes.add(animeInSrcStack);
                }
            }
        }
        return filteredAnimes;
    }
    private void checkIfStackNameAlreadyTakenInUserLibrary(String name, Long userId){
        Library library = libraryService.getLibraryByUserId(userId);
        if( stackRepository.existStackWithNameInLibrary(name, library.getId())){
            throw new NameAlreadyTakenException("Name already Taken");
        }
    }
}
