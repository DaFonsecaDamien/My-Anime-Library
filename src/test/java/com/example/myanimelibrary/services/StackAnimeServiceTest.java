package com.example.myanimelibrary.services;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.Stack;
import com.example.myanimelibrary.domain.StackAnime;
import com.example.myanimelibrary.domain.repositories.StackAnimeRepository;
import com.example.myanimelibrary.domain.service.StackAnimeService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
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
public class StackAnimeServiceTest {

    @Autowired
    StackAnimeService stackAnimeService;

    @MockBean
    private StackAnimeRepository stackAnimeRepository;

    @BeforeAll
    public static void setUp(){

    }

    @Test
    public void should_return_stack_anime_when_saving_stack_anime(){
        Anime anime = new Anime();
        Stack stack = new Stack();
        StackAnime stackAnime = new StackAnime();
        stackAnime.setId(1L);



        when(stackAnimeRepository.saveStackAnime(stackAnime)).thenReturn(stackAnime);
        StackAnime saveStackAnime = stackAnimeService.saveAnimeInStack(stack, anime);

        Assert.assertNotNull(saveStackAnime);
        Assertions.assertEquals(Long.valueOf(1), saveStackAnime.getId());
    }

    @Test
    public void should_return_stack_anime_list_when_saving_animes_in_stack(){
        Anime anime = new Anime();
        Stack stack = new Stack();
        StackAnime stackAnime = new StackAnime();
        stackAnime.setId(1L);


        when(stackAnimeRepository.saveStackAnime(stackAnime)).thenReturn(stackAnime);
        List<StackAnime> saveStackAnime = stackAnimeService.saveAnimesInStack(List.of(anime), stack);

        Assert.assertNotNull(saveStackAnime);
        Assert.assertEquals(1, saveStackAnime.size() );
    }

    @Test
    public void should_return_stack_anime_list_when_get_by_stack_id(){
        StackAnime stackAnime = new StackAnime();
        stackAnime.setId(1L);


        when(stackAnimeRepository.getAllAnimeFromStackId(1L)).thenReturn(List.of(new StackAnime(), new StackAnime()));
        List<StackAnime> saveStackAnime = stackAnimeService.getAllAnimeInStackByStackId(1L);

        Assert.assertNotNull(saveStackAnime);
        Assert.assertEquals(2, saveStackAnime.size() );
    }
}
