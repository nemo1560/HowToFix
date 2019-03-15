package com.example.nemo1.ifixit.M;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {


    public static Retrofit RetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.ifixit.com/api/2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
