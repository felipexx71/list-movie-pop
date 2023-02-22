package com.example.listpopmovie.models;

public class Movie {

    private String moviename;

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public Movie(String moviename) {
        this.moviename = moviename;
    }
}
