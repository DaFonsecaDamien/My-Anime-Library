package com.example.myanimelibrary.infrastructure.repositories;

import com.example.myanimelibrary.domain.Manga;
import com.example.myanimelibrary.domain.SearchFilter;
import com.example.myanimelibrary.domain.repositories.MangaRepository;
import com.example.myanimelibrary.infrastructure.entities.MangaEntity;
import com.example.myanimelibrary.infrastructure.exception.ResourceNotFoundException;
import com.example.myanimelibrary.infrastructure.jparepositories.JPAMangaRepository;
import com.example.myanimelibrary.infrastructure.mapper.MangaMapper;
import com.example.myanimelibrary.infrastructure.mapper.MangaScoreMapper;
import com.example.myanimelibrary.infrastructure.mapper.SpecificationMangaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@Primary
public class MangaRepositoryInfra implements MangaRepository {

    private final JPAMangaRepository jpaMangaRepository;
    private final MangaScoreRepositoryInfra scoreRepositoryInfra;
    private final MangaMapper mangaMapper;
    private final MangaScoreMapper scoreMapper;

    @Autowired
    public MangaRepositoryInfra(JPAMangaRepository jpaMangaRepository, MangaScoreRepositoryInfra scoreRepositoryInfra, MangaMapper mangaMapper, MangaScoreMapper scoreMapper) {
        this.jpaMangaRepository = jpaMangaRepository;
        this.scoreRepositoryInfra = scoreRepositoryInfra;
        this.mangaMapper = mangaMapper;
        this.scoreMapper = scoreMapper;
    }

    @Override
    public List<Manga> findByFilters(List<SearchFilter> filters) {
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
        List<MangaEntity> mangaEntities;
        if (filteredFilters.size() > 0) {
            mangaEntities = jpaMangaRepository.findAll(SpecificationMangaMapper.FromSearchFilterToSpecification(filteredFilters));
        } else {
            mangaEntities = jpaMangaRepository.findAll();
        }
        List<MangaEntity> animeEntitiesPostFiltered = getMangaEntityByApplyingPostFilters(postQueryFilters, mangaEntities);

        return animeEntitiesPostFiltered.stream().map(mangaMapper::FromEntityToModel).collect(Collectors.toList());
    }

    private List<MangaEntity> getMangaEntityByApplyingPostFilters(List<SearchFilter> filters, List<MangaEntity> mangaEntities) {
        List<MangaEntity> filteredMangaEntities = new ArrayList<>();
        for (int j = 0; j < filters.size(); j++) {
            for (MangaEntity mangaEntity : mangaEntities) {
                if (filters.get(j).getField().equals("title")) {
                    if (mangaEntity.getTitles().get("") != null &&
                            mangaEntity.getTitles().get("").matches("(?i).*" + filters.get(j).getValue() + ".*")) {
                        filteredMangaEntities.add(mangaEntity);
                        continue;
                    }
                    if (mangaEntity.getTitles().get("ja") != null &&
                            mangaEntity.getTitles().get("ja").matches("(?i).*" + filters.get(j).getValue() + ".*")) {
                        filteredMangaEntities.add(mangaEntity);
                        continue;
                    }
                    if (mangaEntity.getTitles().get("en") != null &&
                            mangaEntity.getTitles().get("en").matches("(?i).*" + filters.get(j).getValue() + ".*")) {
                        filteredMangaEntities.add(mangaEntity);
                        continue;
                    }
                }
                if (filters.get(j).getField().equals("genre")) {
                    if (!Collections.disjoint(filters.get(j).getValues(), mangaEntity.getGenre())) {
                        filteredMangaEntities.add(mangaEntity);
                    }
                }
            }
            if (j == filters.size() - 1) {
                break;
            }
            mangaEntities = new ArrayList<>(filteredMangaEntities);
            filteredMangaEntities = new ArrayList<>();
        }
        return filteredMangaEntities;
    }

    @Override
    public Manga getMangaById(Long id) {
        Optional<MangaEntity> mangaEntityOptional = jpaMangaRepository.findById(id);
        if (mangaEntityOptional.isEmpty()) {
            throw new ResourceNotFoundException("Element not found");
        }
        return mangaMapper.FromEntityToModel(jpaMangaRepository.getMangaEntityById(id));
    }

    @Override
    public Manga saveManga(Manga manga) {
        System.out.println(manga.getId() + ".//////////////");
        MangaEntity mangaToSave = new MangaEntity(
                manga.getId(),
                manga.getTitles(),
                manga.getImageUrl(),
                manga.getStartDate(),
                manga.getChapters(),
                manga.getVolumes(),
                manga.getAuthor(),
                manga.getState(),
                manga.getSynopsys(),
                manga.getType(),
                manga.getGenres(),
                manga.getAverageScore(),
                manga.getNbVotes(),
                manga.getRanking()
        );
        jpaMangaRepository.save(mangaToSave);
        return mangaMapper.FromEntityToModel(mangaToSave);
    }

    @Override
    public Manga findByTitlesContains(String title) {
        return mangaMapper.FromEntityToModel(jpaMangaRepository.findByTitlesContains(title));
    }

    @Override
    public boolean existsMangaEntityByTitlesContaining(String title) {
        return jpaMangaRepository.existsMangaEntityByTitlesContaining(title);
    }
}
