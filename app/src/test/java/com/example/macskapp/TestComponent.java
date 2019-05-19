package com.example.macskapp;

import com.example.macskapp.mock.MockNetworkModule;
import com.example.macskapp.test.CatTest;
import com.example.macskapp.test.MainTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class})
public interface TestComponent extends MacskAppApplicationComponent {
    void inject(MainTest mainTest);

    void inject(CatTest catTest);
}