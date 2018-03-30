package com.example.jajodia.ret.api.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ruturaj on 1/12/17.
 */

public class Client {
    public static Retrofit mInstance = null;

    public static Retrofit getClient(){
        if(mInstance == null){
            mInstance = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.github.com").build();
        }
        return mInstance;
    }
}
