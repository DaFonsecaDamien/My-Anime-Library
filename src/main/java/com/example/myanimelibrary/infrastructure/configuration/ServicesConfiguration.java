package com.example.myanimelibrary.infrastructure.configuration;

import com.example.myanimelibrary.domain.repositories.*;
import com.example.myanimelibrary.domain.service.*;
import com.example.myanimelibrary.infrastructure.mapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfiguration {

    @Bean
    AnimeService animeService(AnimeRepository animeRepository, UserAnimeReviewRepository userAnimeReviewRepository, ScoreRepository scoreRepository, AnimeMapper animeMapper, SpecificationMapper specificationMapper) {
        return new AnimeService(animeRepository, userAnimeReviewRepository, scoreRepository, animeMapper, specificationMapper);
    }

    @Bean
    ScoreService scoreService(ScoreRepository scoreRepository) {
        return new ScoreService(scoreRepository);
    }

    @Bean
    UserAnimeReviewService userAnimeReviewService(UserAnimeReviewRepository userAnimeReviewRepository, AnimeService animeService, AnimeRepository animeRepository, UserAnimeReviewMapper userAnimeReviewMapper) {
        return new UserAnimeReviewService(userAnimeReviewRepository, animeService, animeRepository, userAnimeReviewMapper);
    }

    @Bean
    LibraryService libraryService(LibraryRepository libraryRepository) {
        return new LibraryService(libraryRepository);
    }

    @Bean
    StackAnimeService stackAnimeService(StackAnimeRepository stackAnimeRepository) {
        return new StackAnimeService(stackAnimeRepository);
    }

    @Bean
    StackMangaService stackMangaService(StackMangaRepository stackMangaRepository) {
        return new StackMangaService(stackMangaRepository);
    }

    @Bean
    UserService userService(UserRepository userRepository){
        return new UserService(userRepository);
    }
    
    @Bean
    StackService stackService(StackAnimeService stackAnimeService, StackMangaService stackMangaService, LibraryService libraryService, StackRepository stackRepository, StackMapper stackMapper, AnimeService animeService, MangaService mangaService) {
        return new StackService(stackAnimeService, stackMangaService, libraryService, stackRepository, stackMapper, animeService, mangaService);
    }

    @Bean
    MangaScoreService mangaScoreService(MangaScoreRepository mangaScoreRepository) {
        return new MangaScoreService(mangaScoreRepository);
    }

    @Bean
    MangaService mangaService(MangaRepository mangaRepository, UserMangaReviewRepository userMangaReviewRepository, MangaScoreRepository mangaScoreRepository, MangaMapper mangaMapper, SpecificationMangaMapper specificationMangaMapper) {
        return new MangaService(mangaRepository, userMangaReviewRepository, mangaScoreRepository, mangaMapper, specificationMangaMapper);
    }

    @Bean
    UserMangaReviewService userMangaReviewService(UserMangaReviewRepository userMangaReviewRepository, MangaService mangaService, MangaRepository mangaRepository, UserMangaReviewMapper userMangaReviewMapper) {
        return new UserMangaReviewService(userMangaReviewRepository, mangaService, mangaRepository, userMangaReviewMapper);
    }
}
