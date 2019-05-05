package com.example.macskapp;

import com.example.macskapp.interactor.cat.CatInteractor;
import com.example.macskapp.network.NetworkModule;
import com.example.macskapp.ui.UIModule;
import com.example.macskapp.ui.macsklist.MacskListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class})
public interface MacskAppApplicationComponent {

        void inject(MacskListActivity macskListActivity);

        void inject(MacskAddActivity macskAddActivity);

        void inject(MacskAboutActivity macskAboutActivity);

        //void inject(CatFragment catFragment);

        void inject(CatInteractor catInteractor);

        //void inject(CatPresenter catPresenter);
}
