package com.example.myanimelibrary.domain.repositories;

import com.example.myanimelibrary.domain.StackAnime;

import java.util.List;

public interface StackAnimeRepository {

    StackAnime saveStackAnime(StackAnime stackAnime);

    void deleteStackAnimeById(Long stackAnimeId);

    List<StackAnime> getAllAnimeFromStackId(Long stackId);

    StackAnime getStackAnimeById(Long id);

    boolean existAnimeInStack(Long animeId, Long stackId);


}
