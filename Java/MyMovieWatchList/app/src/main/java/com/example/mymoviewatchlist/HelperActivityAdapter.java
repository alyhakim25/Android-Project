package com.example.mymoviewatchlist;

public class HelperActivityAdapter {
    String movie;

    public HelperActivityAdapter(String movie) {
        this.movie = movie;
    }

    public HelperActivityAdapter() {
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
}
