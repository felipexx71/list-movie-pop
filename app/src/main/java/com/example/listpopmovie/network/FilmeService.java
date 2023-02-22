package com.example.listpopmovie.network;

import com.example.listpopmovie.network.response.FilmeResult;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmeService {
    @GET("movie/popular")
    Call<FilmeResult> obterFilmesPop(@Query("api_key") String chaveApi);



}
