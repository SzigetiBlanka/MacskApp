package com.example.macskapp;

import com.example.macskapp.interactor.cat.CatInteractor;
import com.example.macskapp.network.NetworkModule;
import com.example.macskapp.ui.UIModule;
import com.example.macskapp.ui.macskAdd.MacskAddActivity;
import com.example.macskapp.ui.macskMain.MacskMainPresenter;
import com.example.macskapp.ui.macsklist.MacskFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class})
public interface MacskAppApplicationComponent {
        //void inject(MacskMainActivity macskMainActivity);

        void inject(MacskAddActivity macskAddActivity);

        void inject(MacskAboutActivity macskAboutActivity);

        void inject(MacskFragment macskFragment);

        void inject(CatInteractor catInteractor);
}
