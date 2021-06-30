package com.example.keephealty.api;

import com.example.keephealty.model.login.Login;
import com.example.keephealty.model.register.Register;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

   @FormUrlEncoded
    @POST("login.php")
    Call<Login> loginResponse(
            @Field("name") String name,
            @Field("password") String password
   );

    @FormUrlEncoded
    @POST("register.php")
    Call<Register> registerResponse(
            @Field("name") String name,
            @Field("password") String password,
            @Field("email") String email,
            @Field("alamat") String alamat,
            @Field("nomor") String nomor

    );

}
