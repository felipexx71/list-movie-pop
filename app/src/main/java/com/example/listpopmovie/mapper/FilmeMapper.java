package com.example.listpopmovie.mapper;

import androidx.annotation.NonNull;

import com.example.listpopmovie.models.Movie;
import com.example.listpopmovie.network.response.FilmeResponse;

import java.util.ArrayList;
import java.util.List;

public class FilmeMapper {
    public static List<Movie> deResponseParaDominio(List<FilmeResponse> listFilmeResponse) {
        List<Movie> movieList = new ArrayList<>();

        for (FilmeResponse filmeResponse: listFilmeResponse) {
            final Movie filme = new Movie(filmeResponse.getTituloOriginal(), filmeResponse.getCaminhoPoster(), filmeResponse.getOriginalLang());
            movieList.add(filme);
        }
        return movieList;
    }
}
