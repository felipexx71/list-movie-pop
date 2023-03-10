package com.example.listpopmovie.network.response;

import com.squareup.moshi.Json;

public class FilmeResponse {

    @Json(name = "poster_path")
    private final String caminhoPoster;

    @Json(name = "original_title")
    private final String tituloOriginal;

    @Json(name = "original_language")
    private final String originalLang;

    public String getOriginalLang() {
        return originalLang;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public FilmeResponse(String caminhoPoster, String tituloOriginal, String originalLang) {
        this.caminhoPoster = caminhoPoster;
        this.tituloOriginal = tituloOriginal;
        this.originalLang = originalLang;
    }
}
