package com.example.listpopmovie.ui;

import com.example.listpopmovie.mapper.FilmeMapper;
import com.example.listpopmovie.models.Movie;
import com.example.listpopmovie.network.ApiService;
import com.example.listpopmovie.network.response.FilmeResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesPresenter implements ListaFilmesContrato.ListaFilmesPresenter{

    private ListaFilmesContrato.ListaFilmesView view;
    @Override
    public void setView(ListaFilmesContrato.ListaFilmesView view) {
        this.view = view;
    }

    @Override
    public void destruirView() {
        this.view = null;
    }

    @Override
    public void obtemFilmes() {
        ApiService.getInstance().obterFilmesPop("55e335efc9cdb311f542728b3ae1e497")
                .enqueue(new Callback<FilmeResult>() {
                    @Override
                    public void onResponse(Call<FilmeResult> call, Response<FilmeResult> response) {
                        if (response.isSuccessful()) {
                            final List<Movie> listafilmes = FilmeMapper
                                    .deResponseParaDominio(response.body().getResults());
                            view.mostraFilmes(listafilmes);

                        } else {
                            view.mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmeResult> call, Throwable t) {
                        view.mostraErro();
                    }
                });
    }
}
