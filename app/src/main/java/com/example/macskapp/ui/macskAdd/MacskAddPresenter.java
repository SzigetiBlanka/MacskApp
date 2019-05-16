package com.example.macskapp.ui.macskAdd;

import com.example.macskapp.model.Cat;
import com.example.macskapp.ui.Presenter;

import javax.inject.Inject;

public class MacskAddPresenter extends Presenter<MacskAddScreen> {
    @Inject
    public MacskAddPresenter(){
    }

    @Override
    public void attachScreen(MacskAddScreen screen){
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen(){
        super.detachScreen();
    }
    public void saveCat(
            Cat m) {
        screen.saveCat(m);
    }
}
