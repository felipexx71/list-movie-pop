package com.example.listpopmovie.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.LinearLayout;

import com.example.listpopmovie.R;
import com.example.listpopmovie.movieadapter.Adapter;
import com.example.listpopmovie.network.ApiService;
import com.example.listpopmovie.network.response.FilmeResponse;
import com.example.listpopmovie.network.response.FilmeResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private List<FilmeResponse> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);

        ApiService.getInstance().obterFilmesPop("55e335efc9cdb311f542728b3ae1e497")
                .enqueue(new Callback<FilmeResult>() {
                    @Override
                    public void onResponse(Call<FilmeResult> call, Response<FilmeResult> response) {
                        if (response.isSuccessful()) {
                            RecyclerView.LayoutManager layout = new LinearLayoutManager(MainActivity.this);

                            recycler.setLayoutManager(layout);

                            recycler.setHasFixedSize(true);

                            recycler.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));

                            recycler.setAdapter(new Adapter(response.body().getResults()));
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmeResult> call, Throwable t) {

                    }
                });
    }
}
