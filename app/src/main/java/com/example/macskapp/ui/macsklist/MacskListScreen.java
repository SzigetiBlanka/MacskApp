package com.example.macskapp.ui.macsklist;

import com.example.macskapp.model.Cat;

public interface MacskListScreen {
    void showCats();

    void showCat(Cat cat);

    void showNetworkError(String errorMsg);
}
