package com.baktiyar.android.translator.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Network {

    public static Retrofit initRetrofit(String URL) {
        return new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(initGson()))
                .build();
    }

    private static Gson initGson() {
        return new GsonBuilder().create();
    }
}