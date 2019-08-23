package com.shera.internexttv.controller.services;

import com.shera.internexttv.utils.Constant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LoginService {

    @GET(Constant.LOGIN_URL)
    Call<ResponseBody> login(@Query("username") String username,@Query("password") String password,@Query("type") String type,@Query("output") String output);
}
