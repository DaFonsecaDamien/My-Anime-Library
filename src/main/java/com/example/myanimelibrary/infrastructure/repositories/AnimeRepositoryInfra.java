package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.SearchFilter;
import com.example.myanimelibrary.domain.repositories.AnimeRepository;
import com.example.myanimelibrary.infrastructure.entities.AnimeEntity;
import com.example.myanimelibrary.infrastructure.exception.ResourceNotFoundException;
import com.example.myanimelibrary.infrastructure.jparepositories.JPAAnimeRepository;
import com.example.myanimelibrary.infrastructure.mapper.AnimeMapper;
import com.example.myanimelibrary.infrastructure.mapper.ScoreMapper;
import com.example.myanimelibrary.infrastructure.mapper.SpecificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@Primary
public class AnimeRepositoryInfra implements AnimeRepository {

    private final JPAAnimeRepository jpaAnimeRepository;
    private final ScoreRepositoryInfra scoreRepositoryInfra;
    private final AnimeMapper animeMapper;
    private final ScoreMapper scoreMapper;

    @Autowired
    public AnimeRepositoryInfra(JPAAnimeRepository jpaAnimeRepository, ScoreRepositoryInfra scoreRepositoryInfra, AnimeMapper animeMapper, ScoreMapper scoreMapper) {
        this.jpaAnimeRepository = jpaAnimeRepository;
        this.scoreRepositoryInfra = scoreRepositoryInfra;
        this.animeMapper = animeMapper;
        this.scoreMapper = scoreMapper;
    }

    @Override
    public List<Anime> findByFilters(List<SearchFilter> filters) {
        List<SearchFilter> postQueryFilters = new ArrayList<>();
        List<SearchFilter> filteredFilters = new ArrayList<>();
        List<String> postQueryFiltersField = Arrays.asList("title", "genre");
        for (SearchFilter filter : filters) {
            if (!Collections.disjoint(Collections.singletonList(filter.getField()), postQueryFiltersField)) {
                postQueryFilters.add(filter);
            } else {
                filteredFilters.add(filter);
            }

        }
        List<AnimeEntity> animeEntities;
        if (filteredFilters.size() > 0) {
            animeEntities = jpaAnimeRepository.findAll(SpecificationMapper.FromSearchFilterToSpecification(filteredFilters));
        } else {
            animeEntities = jpaAnimeRepository.findAll();
        }
        List<AnimeEntity> animeEntitiesPostFiltered = getAnimeEntityByApplyingPostFilters(postQueryFilters, animeEntities);

        return animeEntitiesPostFiltered.stream().map(animeMapper::FromEntityToModel).collect(Collectors.toList());
    }

    private List<AnimeEntity> getAnimeEntityByApplyingPostFilters(List<SearchFilter> filters, List<AnimeEntity> animeEntities) {
        List<AnimeEntity> filteredAnimeEntities = new ArrayList<>();
        for (int j = 0; j < filters.size(); j++) {
            for (int i = 0; i < animeEntities.size(); i++) {
                if (filters.get(j).getField().equals("title")) {
                    if (animeEntities.get(i).getTitles().get("") != null &&
                            animeEntities.get(i).getTitles().get("").matches("(?i).*" + filters.get(j).getValue() + ".*")) {
                        filteredAnimeEntities.add(animeEntities.get(i));
                        continue;
                    }
                    if (animeEntities.get(i).getTitles().get("ja") != null &&
                            animeEntities.get(i).getTitles().get("ja").matches("(?i).*" + filters.get(j).getValue() + ".*")) {
                        filteredAnimeEntities.add(animeEntities.get(i));
                        continue;
                    }
                    if (animeEntities.get(i).getTitles().get("en") != null &&
                            animeEntities.get(i).getTitles().get("en").matches("(?i).*" + filters.get(j).getValue() + ".*")) {
                        filteredAnimeEntities.add(animeEntities.get(i));
                        continue;
                    }
                }
                if (filters.get(j).getField().equals("genre")) {
                    if (!Collections.disjoint(filters.get(j).getValues(), animeEntities.get(i).getGenre())) {
                        filteredAnimeEntities.add(animeEntities.get(i));
                    }
                }
            }
            if (j == filters.size() - 1) {
                break;
            }
            animeEntities = new ArrayList<>(filteredAnimeEntities);
            filteredAnimeEntities = new ArrayList<>();
        }
        return filteredAnimeEntities;
    }

    @Override
    public Anime getAnimeById(Long id) {
        Optional<AnimeEntity> animeEntityOptional = jpaAnimeRepository.findById(id);
        if (animeEntityOptional.isEmpty()) {
            throw new ResourceNotFoundException("Element not found");
        }
        return animeMapper.FromEntityToModel(jpaAnimeRepository.getAnimeEntityById(id));
    }

    @Override
    public Anime saveAnime(Anime anime) {
        System.out.println(anime.getId() + ".//////////////");
        AnimeEntity animeToSave = new AnimeEntity(
                anime.getId() == null ? null : anime.getId(),
                anime.getTitles(),
                anime.getImageUrl(),
                anime.getYear(),
                anime.getEpisodes(),
                anime.getDurationPerEpisodes(),
                anime.getStudio(),
                anime.getSynopsys(),
                anime.getType(),
                anime.getState(),
                anime.getGenre(),
                anime.getAverageScore(),
                anime.getNbVotes(),
                anime.getRanking()
        );
        jpaAnimeRepository.save(animeToSave);
        return animeMapper.FromEntityToModel(animeToSave);
    }

    @Override
    public Anime findByTitlesContains(String title) {
        return animeMapper.FromEntityToModel(jpaAnimeRepository.findByTitlesContains(title));
    }

    @Override
    public boolean existsAnimeEntityByTitlesContaining(String title) {
        return jpaAnimeRepository.existsAnimeEntityByTitlesContaining(title);
    }
}
