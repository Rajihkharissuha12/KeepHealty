package com.example.keephealty.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientLaravel {
//    private static final String BASE_URL = "http://192.168.43.201/applogindanregisterandroid/";
//    private static final String BASE_URL = "http://192.168.43.201:8000/api/";
private static final String BASE_URL = "http://192.168.43.201:8000/api/";

    private static Retrofit retrofit;

    public static Retrofit getClient() {

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
