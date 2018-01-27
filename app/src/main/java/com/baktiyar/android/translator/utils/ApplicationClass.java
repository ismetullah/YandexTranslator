package com.baktiyar.android.translator.utils;

import android.app.Application;

public class ApplicationClass extends Application {

    private String URL = "https://translate.yandex.net/api/v1.5/";

    private ForumService service;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        service = Network.initRetrofit(URL).create(ForumService.class);
    }

    public ForumService getService() {
        return service;
    }

}