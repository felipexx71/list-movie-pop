package com.example.listpopmovie.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.listpopmovie.R;
import com.example.listpopmovie.mapper.FilmeMapper;
import com.example.listpopmovie.models.Movie;
import com.example.listpopmovie.network.ApiService;
import com.example.listpopmovie.network.response.FilmeResponse;
import com.example.listpopmovie.network.response.FilmeResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ListaFilmesContrato.ListaFilmesView{
    private RecyclerView recycler;
    private List<FilmeResponse> listaFilmes = new ArrayList<>();
    private Adapter adapter;
    private ListaFilmesContrato.ListaFilmesPresenter presenter;
    FilmeMapper mapper = new FilmeMapper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configAdapter();

        presenter = new ListaFilmesPresenter();

        presenter.setView(this);

        presenter.obtemFilmes();


    }

    private void configAdapter() {
        recycler = findViewById(R.id.recycler);

        adapter = new Adapter();

        RecyclerView.LayoutManager layout = new GridLayoutManager(this, 2);

        recycler.setLayoutManager(layout);

        recycler.setHasFixedSize(true);

        recycler.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));

        recycler.setAdapter(adapter);
    }

    @Override
    public void mostraFilmes(List<Movie> filme) {
        adapter.setFilmes(filme);
    }

    @Override
    public void mostraErro() {
        Toast.makeText(this, "Erro ao obter lista de filmes!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destruirView();
    }
}
