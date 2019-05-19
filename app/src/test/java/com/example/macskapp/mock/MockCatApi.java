package com.example.macskapp.mock;

import com.example.macskapp.model.Cat;
import com.example.macskapp.model.CatResult;
import com.example.macskapp.model.CatsResult;
import com.example.macskapp.network.CatApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class MockCatApi implements CatApi {
    @Override
    public Call<CatResult> getCats(String key, String title) {
        final CatResult catResult = new CatResult();

        Cat item = new Cat();
        item.setCatName();
        item.setDescription("persze....nahhmégmitnem");
        item.setUrl("https://24.p3k.hu/app/uploads/2018/09/thinkstockphotos-547535754-1024x683.jpg");


        Call<CatResult> call = new Call<CatResult>() {
            @Override
            public Response<CatResult> execute() throws IOException {
                return Response.success(catResult);
            }

            @Override
            public void enqueue(Callback<CatResult> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<CatResult> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }
}
