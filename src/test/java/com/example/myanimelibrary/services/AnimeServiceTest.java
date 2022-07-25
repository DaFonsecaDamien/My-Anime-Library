package com.example.myanimelibrary.services;

import com.example.myanimelibrary.configuration.ServicesTestConfiguration;
import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.AnimeState;
import com.example.myanimelibrary.domain.FilterOperationMode;
import com.example.myanimelibrary.domain.SearchFilter;
import com.example.myanimelibrary.domain.repositories.AnimeRepository;
import com.example.myanimelibrary.domain.repositories.ScoreRepository;
import com.example.myanimelibrary.domain.service.AnimeService;
import com.example.myanimelibrary.infrastructure.request.SearchAnimeRequest;
import com.sun.jdi.LongValue;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.*;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AnimeServiceTest {

    @Autowired
    AnimeService animeService;

    @MockBean
    private AnimeRepository animeRepository;

    @MockBean
    private ScoreRepository scoreRepository;


    @BeforeAll
    public static void setUp(){

    }

    @Test
    public void should_return_an_anime_when_get_anime_by_id(){
        Anime anime = new Anime();
        anime.setId(1L);

        when(animeRepository.getAnimeById(1L)).thenReturn(anime);
        Anime animeFound = animeService.getAnimeById(1L);

        Assert.assertNotNull(animeFound);
        Assert.assertEquals(Long.valueOf(1L), animeFound.getId());
    }

    @Test
    public void should_return_an_anime_when_search_in_db(){
        SearchFilter searchFilter = new SearchFilter();
        List<SearchFilter> searchFilters = new ArrayList<>(Arrays.asList(searchFilter));
        SearchAnimeRequest searchAnimeRequest = new SearchAnimeRequest(searchFilters);
        List<Anime> animes = new ArrayList<>(Arrays.asList(new Anime()));

        when(animeRepository.findByFilters(searchFilters)).thenReturn(animes);
        List<Anime> animeFound = animeService.searchInDb(searchAnimeRequest);

        Assert.assertNotNull(animeFound);
        Assert.assertEquals(1, animeFound.size());
    }

    @Test
    public void should_return_an_anime_when_save_data_from_api(){
        Anime animeTest = new Anime();
        animeTest.setTitles(Collections.singletonMap("", "test"));
        List<Anime> animes = new ArrayList<>(Arrays.asList(animeTest));

        when(scoreRepository.saveScoreGenerated(List.of())).thenReturn(null);
        when(animeRepository.saveAnime(animeTest)).thenReturn(animeTest);
        when(animeRepository.existsAnimeEntityByTitlesContaining(animeTest.getTitles().get(""))).thenReturn(false);

        List<Anime> animeFound = animeService.saveDataFromApi(animes);

        Assert.assertNotNull(animeFound);
        Assert.assertEquals(1, animeFound.size());
    }

    @Test
    public void should_return_an_anime_when_save_search_in_api() throws IOException {
        SearchFilter name = new SearchFilter("title", FilterOperationMode.IN, "naruto", List.of());
        SearchFilter genre = new SearchFilter("genre", FilterOperationMode.IN, "", List.of("Gourmet"));
        List<SearchFilter> searchFilters = Arrays.asList(name,genre);
        SearchAnimeRequest searchAnimeRequest = new SearchAnimeRequest(searchFilters);
        Anime animeTest = new Anime();
        animeTest.setTitles(Collections.singletonMap("", "test"));

        when(animeRepository.saveAnime(animeTest)).thenReturn(animeTest);
        when(scoreRepository.saveScoreGenerated(List.of())).thenReturn(null);
        when(animeRepository.existsAnimeEntityByTitlesContaining(animeTest.getTitles().get(""))).thenReturn(false);
        when(animeRepository.findByFilters(searchFilters)).thenReturn(List.of());

        List<Anime> animes = animeService.searchAnime(searchAnimeRequest);

        Assert.assertNotNull(animes);
        Assert.assertEquals(25, animes.size());
    }
}
