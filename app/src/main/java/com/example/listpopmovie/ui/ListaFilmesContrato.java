package com.example.listpopmovie.ui;

import com.example.listpopmovie.models.Movie;

import java.util.List;

public interface ListaFilmesContrato {

    interface ListaFilmesView{
        void mostraFilmes(List<Movie> filme);
        void mostraErro();
    }

    interface ListaFilmesPresenter{
        void setView(ListaFilmesView view);
        void destruirView();
        void obtemFilmes();
    }
}
