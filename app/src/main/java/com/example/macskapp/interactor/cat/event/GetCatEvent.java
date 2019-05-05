package com.example.macskapp.interactor.cat.event;

import com.example.macskapp.model.Cat;

public class GetCatEvent {
    private int code;
    private Cat cat;
    private Throwable throwable;

    public GetCatEvent() {
    }

    public GetCatEvent(int code, Cat cat, Throwable throwable) {
        this.code = code;
        this.cat = cat;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
