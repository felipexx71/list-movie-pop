package com.example.listpopmovie.network.response;

import com.squareup.moshi.Json;

import java.util.List;

public class FilmeResult {

    @Json(name = "results")
    private List<FilmeResponse> results;

    public List<FilmeResponse> getResults() {
        return results;
    }

    public FilmeResult(List<FilmeResponse> results) {
        this.results = results;
    }
}
