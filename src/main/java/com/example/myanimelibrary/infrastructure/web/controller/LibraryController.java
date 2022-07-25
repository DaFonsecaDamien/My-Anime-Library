package com.example.myanimelibrary.infrastructure.web.controller;

import com.example.myanimelibrary.domain.Stack;
import com.example.myanimelibrary.domain.StackAnime;
import com.example.myanimelibrary.domain.service.AnimeService;
import com.example.myanimelibrary.domain.service.LibraryService;
import com.example.myanimelibrary.domain.service.StackService;
import com.example.myanimelibrary.infrastructure.request.AddAnimeToStackRequest;
import com.example.myanimelibrary.infrastructure.request.CopyStackRequest;
import com.example.myanimelibrary.infrastructure.request.CreateStackRequest;
import com.example.myanimelibrary.infrastructure.request.UpdateStackRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/animeList/library")
public class LibraryController {

    private final AnimeService animeService;
    private final LibraryService libraryService;
    private final StackService stackService;

    @Autowired
    public LibraryController(AnimeService animeService, LibraryService libraryService, StackService stackService) {
        this.animeService = animeService;
        this.libraryService = libraryService;
        this.stackService = stackService;
    }

    @PostMapping("/createStack") // ok
    public ResponseEntity<Stack> createStack(@RequestBody CreateStackRequest request){
        return ResponseEntity.ok(stackService.createStack(request));
    }

    @GetMapping("/{id}/stacks") // ok
    public ResponseEntity<List<Stack>> getStacks(@PathVariable("id") Long libraryId){
        return ResponseEntity.ok(stackService.getAllStackFromLibraryId(libraryId));
    }

    @PostMapping("/stack/copyStack") // ok but add verification of name and don't copy existing anime
    public ResponseEntity<Stack> copyStack(@RequestBody CopyStackRequest request){
        return ResponseEntity.ok(stackService.copyStackByStackId(request));
    }

    @GetMapping("/stack/{stackId}/details")//ok
    public ResponseEntity<Stack> getStackById(@PathVariable("stackId") Long stackId){
        return ResponseEntity.ok(stackService.getLoadedStackById(stackId));
    }

    @GetMapping("/stack/{stackId}/getAnimes")// ok
    public ResponseEntity<List<StackAnime>> getAllAnimeInStackByStackId(@PathVariable("stackId") Long stackId){
        return ResponseEntity.ok(stackService.getAllAnimeInStack(stackId));
    }

    @PostMapping("/stack/addAnime")//ok
    public ResponseEntity<StackAnime> addAnimeToStack(@RequestBody AddAnimeToStackRequest request){
        return ResponseEntity.ok(stackService.saveAnimeInStack(request.getAnimeId(), request.getStackId()));
    }

    @PutMapping("/stack/update")// ok
    public ResponseEntity<Stack> updateStack(@RequestBody UpdateStackRequest request){
        return ResponseEntity.ok(stackService.updateStackById(request));
    }

    @DeleteMapping("/stack/{id}/delete") //ok
    public ResponseEntity<Void> deleteStackById(@PathVariable("id") Long stackId){
        stackService.deleteStackById(stackId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/stack/stackAnime/{id}/delete") // ok
    public ResponseEntity<Void> deleteAnimeInStackById(@PathVariable("id") Long stackAnimeId){
        stackService.deleteAnimeInStack(stackAnimeId);
        return ResponseEntity.ok().build();
    }


}
