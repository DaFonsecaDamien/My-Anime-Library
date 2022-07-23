package com.example.myanimelibrary.anime.repositories;

import com.example.myanimelibrary.configuration.ServicesTestConfiguration;
import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.AnimeState;
import com.example.myanimelibrary.domain.service.AnimeService;
import com.example.myanimelibrary.infrastructure.repositories.AnimeRepositoryInfra;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
public class RepositoriesTest {


    @Autowired
    AnimeService animeService;



    @Test
    public void should_save_anime(){
        Map<String, String> titles = new HashMap<>();
        titles.put("en", "titre en");
        titles.put("fr", "titre fr");
        Anime anime = new Anime();
        anime.setId(5L);
        anime.setTitles(titles);
        anime.setImageUrl("image.url");
        anime.setYear(2020);
        anime.setEpisodes(15);
        anime.setDurationPerEpisodes("15sec");
        anime.setStudio("Pierrot");
        anime.setSynopsys("synopsys");
        anime.setType("anime");
        anime.setState(AnimeState.CURRENTLY_AIRING);
        anime.setGenre(Arrays.asList("genre1", "genre2"));
        anime.setAverageScore(5);
        anime.setNbVotes(5);
        anime.setRanking(0);
        animeService.saveAnime(anime);

        Anime animeFound = animeService.getAnimeById(1L);
        Long id = animeFound.getId();
        Assert.assertNotNull(animeFound);
        Assert.assertEquals(Optional.of(1L), id);
    }
}
