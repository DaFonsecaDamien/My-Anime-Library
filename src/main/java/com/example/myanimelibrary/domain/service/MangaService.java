package com.example.myanimelibrary.domain.service;


import com.example.myanimelibrary.domain.APIManga;
import com.example.myanimelibrary.domain.Manga;
import com.example.myanimelibrary.domain.MangaScore;
import com.example.myanimelibrary.domain.repositories.MangaRepository;
import com.example.myanimelibrary.domain.repositories.MangaScoreRepository;
import com.example.myanimelibrary.domain.repositories.UserMangaReviewRepository;
import com.example.myanimelibrary.infrastructure.mapper.MangaMapper;
import com.example.myanimelibrary.infrastructure.mapper.SpecificationMangaMapper;
import com.example.myanimelibrary.infrastructure.request.SearchMangaRequest;
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

public class MangaService {

    private final MangaRepository mangaRepository;
    private final UserMangaReviewRepository userMangaReviewRepository;
    private final MangaScoreRepository scoreRepository;
    private final MangaMapper mangaMapper;
    private final SpecificationMangaMapper specificationMangaMapper;
    private final Gson gson = new Gson();

    public MangaService(MangaRepository mangaRepository, UserMangaReviewRepository userMangaReviewRepository, MangaScoreRepository scoreRepository, MangaMapper mangaMapper, SpecificationMangaMapper specificationMangaMapper) {
        this.mangaRepository = mangaRepository;
        this.userMangaReviewRepository = userMangaReviewRepository;
        this.scoreRepository = scoreRepository;
        this.mangaMapper = mangaMapper;
        this.specificationMangaMapper = specificationMangaMapper;
    }

    public Manga getMangaById(Long id) {
        return mangaRepository.getMangaById(id);
    }

    public List<Manga> searchManga(SearchMangaRequest searchMangaRequest) throws IOException {
        List<Manga> response = searchInDb(searchMangaRequest);
        if (response.size() == 0) {

            String apiUrl = mangaMapper.searchMangaRequestByApiUrl(searchMangaRequest);
            response = mangaMapper.FromApiToModelList(searchInApi(apiUrl).data);
            System.out.println("url : " + mangaMapper.searchMangaRequestByApiUrl(searchMangaRequest));
        }

        return response;
    }

    public List<Manga> searchInDb(SearchMangaRequest request) {
        return mangaRepository.findByFilters(request.getFilters());
    }

    private APIManga.Root searchInApi(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        // check httpclient / RestTemplate
        String responseFromApi = new String(con.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        con.disconnect();

        System.out.println(responseFromApi);

        APIManga.Root responseGet = gson.fromJson(responseFromApi, APIManga.Root.class);
        saveDataFromApi(mangaMapper.FromApiToModelList(responseGet.data));
        return responseGet;
    }

    public List<Manga> saveDataFromApi(List<Manga> mangasToSave) {
        List<Manga> savedMangas = new ArrayList<>();
        for (Manga manga : mangasToSave) {
            if (!mangaRepository.existsMangaEntityByTitlesContaining(manga.getTitles().get(""))) {
                Manga mangaSaved = mangaRepository.saveManga(manga);
                savedMangas.add(mangaSaved);
                scoreRepository.saveScoreGenerated(MangaScore.generateDefaultScoreList(mangaSaved));
            }
        }
        return savedMangas;
    }

    public void saveManga(Manga manga) {
        mangaRepository.saveManga(manga);
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
