package com.example.macskapp.ui.macsklist;

import com.example.macskapp.di.Network;
import com.example.macskapp.interactor.cat.CatInteractor;
import com.example.macskapp.interactor.cat.event.GetCatEvent;
import com.example.macskapp.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class MacskListPresenter extends Presenter<MacskListScreen> {
    Executor networkExecutor;
    CatInteractor catInteractor;

    @Inject
    public MacskListPresenter(@Network Executor networkExecutor, CatInteractor catInteractor) {
        this.networkExecutor = networkExecutor;
        this.catInteractor = catInteractor;
    }

    @Override
    public void attachScreen(MacskListScreen screen) {
        EventBus.getDefault().register(this);
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen();

    }

    public void refreshCats(final String catsQuery) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                catInteractor.getCats(catsQuery);
            }
        });
    }

    public void showCats(){
        screen.showCats();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetCatEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                screen.showCat(event.getCat());
            }
        }
    }

}
