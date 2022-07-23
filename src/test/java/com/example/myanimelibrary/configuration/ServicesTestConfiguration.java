package com.example.myanimelibrary.configuration;

import com.example.myanimelibrary.domain.repositories.*;
import com.example.myanimelibrary.domain.service.*;
import com.example.myanimelibrary.infrastructure.mapper.AnimeMapper;
import com.example.myanimelibrary.infrastructure.mapper.SpecificationMapper;
import com.example.myanimelibrary.infrastructure.mapper.StackMapper;
import com.example.myanimelibrary.infrastructure.mapper.UserAnimeReviewMapper;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@TestConfiguration
public class ServicesTestConfiguration {

    @Bean
    AnimeService animeService(AnimeRepository animeRepository, UserAnimeReviewRepository userAnimeReviewRepository, ScoreRepository scoreRepository, AnimeMapper animeMapper, SpecificationMapper specificationMapper){
        return new AnimeService(animeRepository, userAnimeReviewRepository, scoreRepository, animeMapper, specificationMapper);
    }

    @Bean
    ScoreService scoreService(ScoreRepository scoreRepository){
        return new ScoreService(scoreRepository);
    }

    @Bean
    UserAnimeReviewService userAnimeReviewService(UserAnimeReviewRepository userAnimeReviewRepository, AnimeService animeService, AnimeRepository animeRepository, UserAnimeReviewMapper userAnimeReviewMapper){
        return new UserAnimeReviewService(userAnimeReviewRepository, animeService, animeRepository, userAnimeReviewMapper);
    }

    @Bean
    LibraryService libraryService(LibraryRepository libraryRepository){
        return new LibraryService(libraryRepository);
    }

    @Bean
    StackAnimeService stackAnimeService(StackAnimeRepository stackAnimeRepository){
        return new StackAnimeService(stackAnimeRepository);
    }

    @Bean
    StackService stackService(StackAnimeService stackAnimeService, LibraryService libraryService, StackRepository stackRepository, StackMapper stackMapper, AnimeService animeService){
        return new StackService(stackAnimeService, libraryService, stackRepository, stackMapper, animeService);
    }



}
