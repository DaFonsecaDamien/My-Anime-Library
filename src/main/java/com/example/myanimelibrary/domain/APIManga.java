package com.example.myanimelibrary.domain;

import java.util.ArrayList;

public class APIManga {

    public static class Author {
        public String name;
    }

    public static class Datum {
        public Images images;
        public ArrayList<String> titles;
        public String title;
        public String title_english;
        public String title_japanese;
        public int chapters;
        public int volumes;
        public String status;
        public String synopsis;
        public ArrayList<Author> authors;
        public ArrayList<Genre> genres;
        public Published published;
        public ArrayList<Demographic> demographics;
    }

    public static class Demographic {
        public int mal_id;
        public String type;
        public String name;
        public String url;
    }

    public static class Genre {
        public int mal_id;
        public String type;
        public String name;
        public String url;
    }

    public static class Images {
        public Jpg jpg;
    }

    public static class Jpg {
        public String image_url;
    }

    public static class Published {
        public String from;
    }

    public class Root {
        public ArrayList<Datum> data;
    }
}

