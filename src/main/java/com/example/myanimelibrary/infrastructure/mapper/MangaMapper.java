package com.example.myanimelibrary.infrastructure.mapper;

import com.example.myanimelibrary.domain.APIManga;
import com.example.myanimelibrary.domain.Manga;
import com.example.myanimelibrary.domain.MangaState;
import com.example.myanimelibrary.domain.SearchFilter;
import com.example.myanimelibrary.infrastructure.entities.MangaEntity;
import com.example.myanimelibrary.infrastructure.request.SearchMangaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MangaMapper {

    private final MangaScoreMapper scoreMapper;

    @Autowired
    public MangaMapper(MangaScoreMapper scoreMapper) {
        this.scoreMapper = scoreMapper;
    }

    public List<Manga> FromApiToModelList(ArrayList<APIManga.Datum> apiList) {
        return apiList.stream().map(this::FromApiToModel).collect(Collectors.toList());
    }

    public MangaEntity FromModelToEntity(Manga manga) {
        return new MangaEntity(
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
    }

    public Manga FromEntityToModel(MangaEntity entity) {
        return new Manga(
                entity.getId(),
                entity.getTitles(),
                entity.getImageUrl(),
                entity.getStartDate(),
                entity.getChapters(),
                entity.getVolumes(),
                entity.getAuthor(),
                entity.getSynopsys(),
                entity.getType(),
                entity.getState(),
                entity.getGenre(),
                entity.getAverageScore(),
                entity.getNbVotes(),
                entity.getRanking()
        );
    }

    public Manga FromApiToModel(APIManga.Datum apiData) {
        return new Manga(
                null,
                getMangaTitleFromApiData(apiData.title, apiData.title_english, apiData.title_japanese),
                apiData.images.jpg.image_url,
                LocalDate.parse(apiData.published.from.split("T")[0]),
                apiData.chapters,
                apiData.volumes,
                apiData.authors != null && !apiData.authors.isEmpty() ? apiData.authors.get(0).name : "",
                apiData.synopsis,
                "Manga",
                getMangaStateFromStatus(apiData.status),
                getMangaGenresFromApiData(apiData.genres),
                0,
                0,
                0
        );
    }

    public Map<String, String> getMangaTitleFromApiData(String title, String enTitle, String jaTitle) {
        HashMap<String, String> titles = new HashMap<>();
        titles.put("", title);
        titles.put("en", enTitle);
        titles.put("ja", jaTitle);
        return titles;
    }

    private MangaState getMangaStateFromStatus(String status) {
        return switch (status) {
            case "Finished" -> MangaState.FINISHED;
            case "On Hiatus" -> MangaState.ON_HOLD;
            case "Publishing" -> MangaState.PUBLISHING;
            default -> throw new IllegalStateException("Unexpected value: " + status);
        };
    }

    private List<String> getMangaGenresFromApiData(ArrayList<APIManga.Genre> apiGenres) {
        List<String> genres = new ArrayList<>();
        for (APIManga.Genre apiGenre : apiGenres) {
            genres.add(apiGenre.name);
        }
        return genres;
    }

    public String searchMangaRequestByApiUrl(SearchMangaRequest request) {
        StringBuilder baseApiUrl = new StringBuilder("https://api.jikan.moe/v4/manga?");
        List<SearchFilter> filters = request.getFilters();
        for (SearchFilter filter : filters) {
            switch (filter.getField()) {
                case "genre":
                    baseApiUrl.append("genres=");
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
