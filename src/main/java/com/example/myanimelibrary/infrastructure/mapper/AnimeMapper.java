package com.example.myanimelibrary.infrastructure.mapper;

import com.example.myanimelibrary.domain.APIAnime;
import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.AnimeState;
import com.example.myanimelibrary.domain.SearchFilter;
import com.example.myanimelibrary.infrastructure.entities.AnimeEntity;
import com.example.myanimelibrary.infrastructure.request.SearchAnimeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TODO: create manga mapper
@Component
public class AnimeMapper {

    private final ScoreMapper scoreMapper;

    @Autowired
    public AnimeMapper(ScoreMapper scoreMapper) {
        this.scoreMapper = scoreMapper;
    }

    public List<Anime> FromApiToModelList(ArrayList<APIAnime.Datum> apiList) {
        return apiList.stream().map(this::FromApiToModel).collect(Collectors.toList());
    }


    public AnimeEntity FromModelToEntity(Anime model){
        return new AnimeEntity(
                model.getId(),
                model.getTitles(),
                model.getImageUrl(),
                model.getYear(),
                model.getEpisodes(),
                model.getDurationPerEpisodes(),
                model.getStudio(),
                model.getSynopsys(),
                model.getType(),
                model.getState(),
                model.getGenre(),
                model.getAverageScore(),
                model.getNbVotes(),
                model.getRanking()
        );
    }

    public Anime FromEntityToModel(AnimeEntity entity) {
        return new Anime(entity.getId(),
                entity.getTitles(),
                entity.getImageUrl(),
                entity.getYear(),
                entity.getEpisodes(),
                entity.getDurationPerEpisodes(),
                entity.getStudio(),
                entity.getSynopsys(),
                entity.getType(),
                entity.getState(),
                entity.getGenre(),
                entity.getAverageScore(),
                entity.getNbVotes(),
                entity.getRanking()
        );
    }

    // couche anti corruption
    public Anime FromApiToModel(APIAnime.Datum apiData) {
        return new Anime(null,
                getAnimeTitleFromApiData(apiData.title, apiData.title_english, apiData.title_japanese),
                apiData.images.jpg.image_url,
                apiData.year,
                apiData.episodes,
                apiData.duration,
                apiData.studios.size() == 0 ? "" : apiData.studios.get(0).name,
                apiData.synopsis,
                apiData.demographics.size() == 0 ? "" : apiData.demographics.get(0).name,
                getAnimeStateFromApiData(apiData),
                getGenreFromApiData(apiData),
                0,
                0,
                0
        );
    }

    private AnimeState getAnimeStateFromApiData(APIAnime.Datum apiData) {
        return apiData.status.equals("Finished Airing") ? AnimeState.FINISHED_AIRING : AnimeState.CURRENTLY_AIRING;
    }

    private List<String> getGenreFromApiData(APIAnime.Datum apiData) {
        List<String> genres = new ArrayList<>();
        for (int i = 0; i < apiData.genres.size(); i++) {
            genres.add(apiData.genres.get(i).name);
        }
        return genres;
    }
    
    public Map<String, String> getAnimeTitleFromApiData(String title, String enTitle, String jaTitle) {
        HashMap<String, String> titles = new HashMap<>();
        titles.put("", title);
        titles.put("en", enTitle);
        titles.put("ja", jaTitle);
        return titles;
    }

    public String searchAnimeRequestTuApiUrl(SearchAnimeRequest request) {
        StringBuilder baseApiUrl = new StringBuilder("https://api.jikan.moe/v4/anime?");
        List<SearchFilter> filters = request.getFilters();
        for (int j = 0; j < filters.size(); j++)
        {
            switch (filters.get(j).getField()){
                case "genre" :
                    baseApiUrl += "genre=";
                    // get api genre id https://api.jikan.moe/v4/genres/anime load genre as config
                    for (int i = 0; i < filter.getValues().size(); i++) {
                        if (i == filter.getValues().size() - 1) {
                            baseApiUrl.append(filter.getValues().get(i)).append("&");
                            break;
                        }
                        baseApiUrl.append(filter.getValues().get(i)).append(",");
                    }
                    ;
                    break;
                case "title":
                    baseApiUrl.append("q=").append(filter.getValue()).append("&");
                    break;
                case "score":
                    baseApiUrl.append("score=").append(filter.getValue()).append("&");
                    break;
                case "status":
                    baseApiUrl.append("status=").append(filter.getValue()).append("&");
                    break;
                case "year":
                    baseApiUrl.append("start_date=").append(filter.getValue()).append("&");
                    break;
                default:
                    break;
            }
        }
        return baseApiUrl.toString();
    }
}
