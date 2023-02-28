package com.example.listpopmovie.movieadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listpopmovie.R;
import com.example.listpopmovie.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<Movie> listaFilmes;

    public Adapter() {
        listaFilmes = new ArrayList<>();
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
        holder.bindMovie(listaFilmes.get(position));
    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView movieName;
        private TextView movieLang;
        private ImageView movieImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            movieLang = itemView.findViewById(R.id.textNameLang);
            movieName = itemView.findViewById(R.id.textNameMovie);
            movieImage = itemView.findViewById(R.id.imagePoster);
        }
        public void bindMovie(Movie listFilmes) {
            movieName.setText(listFilmes.getTitulo());
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/original/"+listFilmes.getPoster())
                    .into(movieImage);
            movieLang.setText(listFilmes.getLang());
        }
    }

    public void setFilmes(List<Movie> filmes) {
        this.listaFilmes = filmes;

        //vai fazer o binding de cada item de cada posição para mostrar
        notifyDataSetChanged();
    }

}
