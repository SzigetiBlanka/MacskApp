package com.example.macskapp.interactor.cat.event;

import com.example.macskapp.model.Cat;

import java.util.List;

public class GetCatsEvent {
    private int code;
    private List<Cat> cats;
    private Throwable throwable;

    public GetCatsEvent() {
    }

    public GetCatsEvent(int code, List<Cat> cats, Throwable throwable) {
        this.code = code;
        this.cats = cats;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
