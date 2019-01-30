package com.people.islam.movienerdies;

public class MovieModel {

    private String title;
    private String posterUrl;

    public MovieModel(String title, String posterUrl) {
        this.title = title;
        this.posterUrl = posterUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }
}
