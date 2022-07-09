package com.example.myanimelibrary.domain.service;

import com.example.myanimelibrary.domain.APIAnime;
import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.Score;
import com.example.myanimelibrary.domain.repositories.AnimeRepository;
import com.example.myanimelibrary.domain.repositories.ScoreRepository;
import com.example.myanimelibrary.domain.repositories.UserAnimeReviewRepository;
import com.example.myanimelibrary.infrastructure.mapper.AnimeMapper;
import com.example.myanimelibrary.infrastructure.mapper.SpecificationMapper;
import com.example.myanimelibrary.infrastructure.request.SearchAnimeRequest;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnimeService {

    private final AnimeRepository animeRepository;
    private final UserAnimeReviewRepository userAnimeReviewRepository;
    private final ScoreRepository scoreRepository;
    private final AnimeMapper animeMapper;
    private final SpecificationMapper specificationMapper;
    private final Gson gson = new Gson();

    public AnimeService(AnimeRepository animeRepository, UserAnimeReviewRepository userAnimeReviewRepository, ScoreRepository scoreRepository, AnimeMapper animeMapper, SpecificationMapper specificationMapper) {
        this.animeRepository = animeRepository;
        this.userAnimeReviewRepository = userAnimeReviewRepository;
        this.scoreRepository = scoreRepository;
        this.animeMapper = animeMapper;
        this.specificationMapper = specificationMapper;
    }

    public Anime getAnimeById(Long id){
        return animeRepository.getAnimeById(id);
    }

    public List<Anime> searchAnime(SearchAnimeRequest request) throws IOException {

        List<Anime> response = searchInDb(request);
        if( response.size() == 0 ){

            String apiUrl = animeMapper.searchAnimeRequestTuApiUrl(request);
            response = animeMapper.FromApiToModelList(searchInApi(apiUrl).data);
            System.out.println("url : " + animeMapper.searchAnimeRequestTuApiUrl(request));
        }

        return response;
    }

    private APIAnime.Root searchInApi(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        // check httpclient / RestTemplate
        String responseFromApi = new String(con.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        con.disconnect();

        System.out.println(responseFromApi);

        APIAnime.Root responseGet = gson.fromJson(responseFromApi, APIAnime.Root.class);
        saveDataFromApi(animeMapper.FromApiToModelList(responseGet.data));
        return responseGet;
    }

    public List<Anime> searchInDb(SearchAnimeRequest request)
    {
        //Specification<AnimeEntity> animeEntitySpecification = specificationMapper.FromSearchFilterToSpecification(request.getFilters());
        return animeRepository.findByFilters(request.getFilters());
    }

    public List<Anime> saveDataFromApi(List<Anime> animesToSave){
        List<Anime> savedAnime = new ArrayList<>();
        for (int i = 0; i < animesToSave.size(); i++){
            if( !animeRepository.existsAnimeEntityByTitlesContaining(animesToSave.get(i).getTitles().get(""))){
                Anime animeSaved = animeRepository.saveAnime(animesToSave.get(i));
                savedAnime.add(animeSaved);
                scoreRepository.saveScoreGenerated(Score.generateDefaultScoreList(animeSaved));
            }
        }
        return savedAnime;
    }

    private void saveGeneratedScoreAnime(List<Score> scoresToSave){
        for( int i = 0; i < scoresToSave.size(); i++){
            scoreRepository.saveScore(scoresToSave.get(i));
        }
    }

    public void saveAnime(Anime anime){
        animeRepository.saveAnime(anime);
    }

    public class ParameterStringBuilder {
        public static String getParamsString(Map<String, String> params)
                throws UnsupportedEncodingException {
            StringBuilder result = new StringBuilder();

            for (Map.Entry<String, String> entry : params.entrySet()) {
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                result.append("&");
            }

            String resultString = result.toString();
            return resultString.length() > 0
                    ? resultString.substring(0, resultString.length() - 1)
                    : resultString;
        }
    }

}
