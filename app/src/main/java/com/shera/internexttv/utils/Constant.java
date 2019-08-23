package com.shera.internexttv.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Constant {

    public static final String SERVER_VAL = "http://server.internext.tv:8080/";

    public static final String LOGIN_URL="player_api.php";
    public static final int TIMEOUT = 60 * 1000;

    public final static String SHARED_PREF_NAME = "internext SharedPreference";
    public final static String USER_KEY = "username";
    public final static String PASS_KEY = "password";
    public static Retrofit buildRetrofit(boolean defaultRequest) {
        OkHttpClient okHttpClient = new OkHttpClient();
        if (!defaultRequest) {

            return new Retrofit.Builder()
                    .baseUrl(SERVER_VAL)
                    .client(okHttpClient.newBuilder().connectTimeout(TIMEOUT, TimeUnit.SECONDS).readTimeout(TIMEOUT, TimeUnit.SECONDS).writeTimeout(TIMEOUT, TimeUnit.SECONDS).build())
                    .addConverterFactory(GsonConverterFactory.create(CustomGsonBuilder.getInstance().create()))
                    .build();
        } else {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            return new Retrofit.Builder()
                    .baseUrl(SERVER_VAL)
                    .client(okHttpClient.newBuilder().connectTimeout(TIMEOUT, TimeUnit.SECONDS).readTimeout(TIMEOUT, TimeUnit.SECONDS).writeTimeout(TIMEOUT, TimeUnit.SECONDS).build())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
    }

    public static JSONObject getJsonResponseFromRaw(Response<ResponseBody> response) {

        try {
            return new JSONObject(getStringResponseFromRaw(response));
        } catch (Exception ex) {
            return null;
        }
    }

    public static JSONArray getJsonArrayResponseFromRaw(Response<ResponseBody> response) {

        try {
            return new JSONArray(getStringResponseFromRaw(response));
        } catch (Exception ex) {
            return null;
        }
    }

    public static String getStringResponseFromRaw(Response<ResponseBody> response) {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {

            reader = new BufferedReader(new InputStreamReader(response.body().byteStream()));

            String line;

            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
