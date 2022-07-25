package com.example.myanimelibrary.services;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.Stack;
import com.example.myanimelibrary.domain.StackAnime;
import com.example.myanimelibrary.domain.UserAnimeReview;
import com.example.myanimelibrary.domain.repositories.AnimeRepository;
import com.example.myanimelibrary.domain.repositories.StackAnimeRepository;
import com.example.myanimelibrary.domain.repositories.UserAnimeReviewRepository;
import com.example.myanimelibrary.domain.service.AnimeService;
import com.example.myanimelibrary.domain.service.StackAnimeService;
import com.example.myanimelibrary.domain.service.UserAnimeReviewService;
import com.example.myanimelibrary.infrastructure.request.CreateUserAnimeReviewRequest;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserAnimeReviewTest {

    @Autowired
    UserAnimeReviewService userAnimeReviewService;

    @MockBean
    private UserAnimeReviewRepository userAnimeReviewRepository;
    @MockBean
    private AnimeRepository animeRepository;

    @BeforeAll
    public static void setUp(){

    }

    @Test
    public void should_return_stack_anime_when_saving_stack_anime(){
        UserAnimeReview userAnimeReview = new UserAnimeReview();
        userAnimeReview.setId(1L);
        Anime anime = new Anime();
        anime.setId(1L);
        CreateUserAnimeReviewRequest createUserAnimeReviewRequest = new CreateUserAnimeReviewRequest();
        createUserAnimeReviewRequest.setComment("c");
        createUserAnimeReviewRequest.setAnime(anime);
        createUserAnimeReviewRequest.setCurrentEpisode(1);
        createUserAnimeReviewRequest.setScore(5);
        createUserAnimeReviewRequest.setAnimeSiteUri("te");

        when(animeRepository.getAnimeById(1L)).thenReturn(anime);
        when(userAnimeReviewRepository.saveUserAnimeReview(userAnimeReview)).thenReturn(userAnimeReview);

        UserAnimeReview userAnimeReviewCreated = userAnimeReviewService.createAnimeReview(1L, createUserAnimeReviewRequest);
        System.out.println(userAnimeReviewCreated);
        Assert.assertNotNull(userAnimeReviewCreated);
        Assertions.assertEquals(Long.valueOf(1), userAnimeReviewCreated.getAnime().getId());
    }
}
