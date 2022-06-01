package com.example.myanimelibrary.domain.service;

import com.example.myanimelibrary.domain.APIAnime;
import com.example.myanimelibrary.domain.Anime;
import com.example.myanimelibrary.domain.repositories.AnimeRepository;
import com.example.myanimelibrary.infrastructure.mapper.AnimeMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;
    private final AnimeMapper animeMapper;
    private final Gson gson = new Gson();

    @Autowired
    public AnimeService(AnimeRepository animeRepository, AnimeMapper animeMapper) {
        this.animeRepository = animeRepository;
        this.animeMapper = animeMapper;
    }



    public List<Anime> searchAnime(Map<String, String> parameters) throws IOException {
        ArrayList<Anime> response = new ArrayList<>();

        URL url = new URL("https://api.jikan.moe/v4/anime?q=naruto");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
//        con.setDoOutput(true);

//        DataOutputStream out = new DataOutputStream(con.getOutputStream());
//        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
//        out.flush();
//        out.close();
        String response2 = new String(con.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        con.disconnect();

        System.out.println(response2);

        APIAnime.Root responseGet = gson.fromJson(response2, APIAnime.Root.class);

        return animeMapper.FromApiToModelList(responseGet.data);

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
