package com.shera.internexttv.controller;

import android.content.Context;

import com.shera.internexttv.controller.services.CategoryService;
import com.shera.internexttv.controller.services.LoginService;
import com.shera.internexttv.utils.Constant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class Controller {

    private static Controller instance = new Controller();
    private static Context mContext;

    public static Controller getInstance(Context context) {
        mContext = context;
        return instance;
    }
    public void login(String username,String password, Callback<ResponseBody> callBack) {
        Retrofit retrofit = Constant.buildRetrofit(true);
        LoginService service = retrofit.create(LoginService.class);
        Call<ResponseBody> authenticationResponseCall = service.login(username,password,"m3u_plus","ts");
        authenticationResponseCall.enqueue(callBack);
    }

    public void getCategory(String username,String password, Callback<ResponseBody> callBack) {
        Retrofit retrofit = Constant.buildRetrofit(true);
        CategoryService service = retrofit.create(CategoryService.class);
        Call<ResponseBody> authenticationResponseCall = service.getCategory(username,password,"get_live_streams");
        authenticationResponseCall.enqueue(callBack);
    }
}
