package com.example.macskapp.ui.macskMain;

import com.example.macskapp.ui.Presenter;

import javax.inject.Inject;

public class MacskMainPresenter extends Presenter<MacskMainScreen> {

@Inject
public MacskMainPresenter(){ }

@Override
public void attachScreen(MacskMainScreen screen){
        super.attachScreen(screen);
        }

@Override
public void detachScreen(){
        super.detachScreen();
        }

public void showCatsList() {
        screen.showCats();
        }
}
