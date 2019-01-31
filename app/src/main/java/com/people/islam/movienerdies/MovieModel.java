package com.people.islam.movienerdies;

public class MovieModel {

    private String title;
    private String posterUrl;
    private double vote;
    private String overview;
    private boolean adult;
    private String releaseDate;

    public MovieModel(String title, String posterUrl, double vote, String overview, boolean adult,
                      String releaseDate) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.vote = vote;
        this.overview = overview;
        this.adult = adult;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public double getVote() {
        return vote;
    }

    public String getOverview() {
        return overview;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
