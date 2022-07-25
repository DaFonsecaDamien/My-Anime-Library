package com.example.myanimelibrary.services;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.Score;
import com.example.myanimelibrary.domain.repositories.AnimeRepository;
import com.example.myanimelibrary.domain.repositories.ScoreRepository;
import com.example.myanimelibrary.domain.service.AnimeService;
import com.example.myanimelibrary.domain.service.ScoreService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ScoreServiceTest {

    @Autowired
    ScoreService scoreService;

    @MockBean
    private ScoreRepository scoreRepository;

    @BeforeAll
    public static void setUp(){

    }

    @Test
    public void should_return_list_of_score_when_giving_an_anime(){
        Anime anime = new Anime();


        when(scoreRepository.getAllScoreFromAnime(anime)).thenReturn(List.of(new Score()));
        List<Score> scores = scoreService.getAllscoreFromAnime(anime);

        Assert.assertNotNull(scores);
        Assert.assertEquals(1, scores.size());
    }

    @Test
    public void should_return_score_when_giving_an_anime_an_value(){
        Anime anime = new Anime();
        Score score = new Score();
        score.setValue(1);

        when(scoreRepository.getScoreByValueAndEntity(1, anime)).thenReturn(score);
        Score scores = scoreService.getScoreByAnimeAndValue(1,anime);

        Assert.assertNotNull(scores);
        Assert.assertEquals(Integer.valueOf(1), scores.getValue());
    }
}
