package com.example.listpopmovie.movieadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listpopmovie.R;
import com.example.listpopmovie.network.response.FilmeResponse;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<FilmeResponse> listaFilmes;

    public Adapter(List<FilmeResponse> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_filmes, parent,false);

        return new MyViewHolder( itemLista );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.movieName.setText(listaFilmes.get(position).getTituloOriginal());
    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView movieName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            movieName = itemView.findViewById(R.id.textNameMovie);
        }
    }
}
