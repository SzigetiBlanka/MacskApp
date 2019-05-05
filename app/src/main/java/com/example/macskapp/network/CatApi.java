package com.example.macskapp.network;

import com.example.macskapp.model.CatResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CatApi {
    @GET(" ")
    Call<CatResult> getCats(@Query("x-api-key") String key,
                            @Query("t") String title);
}
