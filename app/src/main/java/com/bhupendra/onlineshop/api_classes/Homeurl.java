package com.bhupendra.onlineshop.api_classes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Homeurl {

    public static Retrofit retrofit = null;
    public static Retrofit getRetrofit(){

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                   .baseUrl("http://192.168.254.55:5000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}