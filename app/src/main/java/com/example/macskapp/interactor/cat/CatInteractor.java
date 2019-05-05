package com.example.macskapp.interactor.cat;

import com.example.macskapp.MacskAppApplication;
import com.example.macskapp.interactor.cat.event.GetCatEvent;
import com.example.macskapp.model.CatResult;
import com.example.macskapp.network.CatApi;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class CatInteractor {
    CatApi catApi;

    @Inject
    public CatInteractor(CatApi catApi) {
        this.catApi = catApi;
        MacskAppApplication.injector.inject(this);
    }

    public void getCats(String catQuery) {
        GetCatEvent event = new GetCatEvent();
        try {
            Call<CatResult> catQueryCall = catApi.getCats("igk1wd", catQuery);
            Response<CatResult> response = catQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setCat(response.body().createCat());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }
}
