package com.rest;

import com.example.keep_healthy.model.GetMitra;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("get-mitra")
    Call<GetMitra> getMitra();
}
