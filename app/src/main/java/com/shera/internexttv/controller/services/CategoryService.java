package com.shera.internexttv.controller.services;

import com.shera.internexttv.utils.Constant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CategoryService {

    @GET(Constant.LOGIN_URL)
    Call<ResponseBody> getCategory(@Query("username") String username, @Query("password") String password, @Query("action") String action);
}
