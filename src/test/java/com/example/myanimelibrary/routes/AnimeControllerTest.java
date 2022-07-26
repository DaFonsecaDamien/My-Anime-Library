package com.example.myanimelibrary.routes;

import Utils.TokenAuthenticationService;
import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.AnimeState;
import com.example.myanimelibrary.domain.repositories.AnimeRepository;
import com.example.myanimelibrary.domain.service.AnimeService;
import com.example.myanimelibrary.infrastructure.repositories.AnimeRepositoryInfra;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AnimeControllerTest {

    private static String token;
    private static Anime anime_1;
    private static Anime anime_2;
    @Autowired
    AnimeRepositoryInfra animeRepositoryInfra;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeAll
    static void init() {
        token = TokenAuthenticationService.addAuthentication("testeur");

        Map<String, String> anime1Titles = new HashMap<>();
        anime1Titles.put("en", "naruto");
        anime1Titles.put("fr", "naruto");
        anime1Titles.put("ja", "naruto");
        Map<String, String> anime2Titles = new HashMap<>();
        anime1Titles.put("en", "bleach");
        anime1Titles.put("fr", "bleach");
        anime1Titles.put("ja", "bleach");
        List<String> anime1genre = new ArrayList<>(List.of("horreur", "surnaturel"));
        List<String> anime2genre = new ArrayList<>(List.of("comique"));

        anime_1 = new Anime(null,
                            anime1Titles,
                            "image.url",
                            2020, 5, "20 sec", "Pierrot", "synopsys 1", "anime", AnimeState.CURRENTLY_AIRING,
                            anime1genre, 0, 0,0
                            );

        anime_2 = new Anime(null,
                anime2Titles,
                "image.url",
                2020, 5, "20 sec", "Pierrot", "synopsys 1", "anime", AnimeState.CURRENTLY_AIRING,
                anime2genre, 0, 0,0
        );
    }


    @Test
    public void getAnimeById() throws Exception {
        Anime animeSaved = animeRepositoryInfra.saveAnime(anime_1);
        MvcResult result = this.mockMvc.perform(get("/animeList/anime/test").header("Authorization", token)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("ok"))).andReturn();
        animeRepositoryInfra.deleteAnimeById(animeSaved.getId());
    }
}
