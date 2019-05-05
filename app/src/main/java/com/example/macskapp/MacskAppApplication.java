package com.example.macskapp;

import com.example.macskapp.ui.UIModule;
import com.orm.SugarApp;

public class MacskAppApplication extends SugarApp {

    public static MacskAppApplicationComponent injector;

    @Override
    public void onCreate(){
        super.onCreate();
        injector = DaggerMacskAppApplicationComponent.builder().
                uIModule(
                        new UIModule(this)
                ).build();

    }
}
