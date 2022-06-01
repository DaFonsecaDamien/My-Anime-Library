package com.example.myanimelibrary.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class APIAnime {

    public class Datum{

        public Images images;
        public String title;
        public String title_english;
        public String title_japanese;
        public int episodes;
        public String status;
        public String duration;
        public String synopsis;
        public Integer year;
        public ArrayList<Studio> studios;
        public ArrayList<Genre> genres;
        public ArrayList<Demographic> demographics;
    }

    public class Demographic{
        public String name;
    }

    public class Genre{
        public String name;
    }

    public class Images{
        public Jpg jpg;
    }

    public class Jpg{
        public String image_url;
    }



    public class Root{
        public ArrayList<Datum> data;
    }

    public class Studio{
        public String name;
    }

}

