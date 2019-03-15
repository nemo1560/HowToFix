package com.example.nemo1.ifixit.Interfaces;

import com.example.nemo1.ifixit.Entity.Objects;
import com.example.nemo1.ifixit.Entity.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetAPIiFixit {
    @GET("search/{search}")
    Call<Objects<Results>>getData(@Path("search")String search);
}
