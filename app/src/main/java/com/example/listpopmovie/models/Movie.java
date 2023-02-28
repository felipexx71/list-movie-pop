package com.example.listpopmovie.models;

public class Movie {

    private String titulo;
    private String poster;
    private String lang;

    public String getLang() {
        return lang;
    }

    public String getPoster() {
        return poster;
    }

    public Movie(String titulo, String poster, String lang) {
        this.titulo = titulo;
        this.poster = poster;
        this.lang = lang;
    }

    public String getTitulo() {
        return titulo;
    }

}
