package com.shera.internexttv.view.channel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hmomeni.progresscircula.ProgressCircula;
import com.shera.internexttv.R;
import com.shera.internexttv.controller.Controller;
import com.shera.internexttv.model.CategoryDTO;
import com.shera.internexttv.model.LiveChannelDTO;
import com.shera.internexttv.utils.Constant;
import com.shera.internexttv.utils.CustomGsonBuilder;
import com.shera.internexttv.view.channel.adapter.ChannelListAdapter;

import org.json.JSONArray;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChannelListActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    ChannelListAdapter channelListAdapter;
    ArrayList<LiveChannelDTO> categoryDTOS;
    @BindView(R.id.progressBar)
    ProgressCircula progressBar;
    @BindView(R.id.no_data_found)
    TextView noDataFound;
    Controller controller;
    private String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_list);
        ButterKnife.bind(this);
        recyclerview.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        sharedPreferences = getSharedPreferences(Constant.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        username=sharedPreferences.getString(Constant.USER_KEY,null);
        password=sharedPreferences.getString(Constant.PASS_KEY,null);
        categoryDTOS = new ArrayList<>();
        channelListAdapter = new ChannelListAdapter(categoryDTOS, this);
        controller= Controller.getInstance(this);
        recyclerview.setAdapter(channelListAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerview.setLayoutManager(manager);
        controller.getCategory(username,password, new GetCategoryListResponse());
    }

    private class GetCategoryListResponse implements Callback<ResponseBody> {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            progressBar.setVisibility(View.GONE);
            if (response.body()!=null){
                if (response.isSuccessful()){
                    recyclerview.setVisibility(View.VISIBLE);
                    JSONArray result= Constant.getJsonArrayResponseFromRaw(response);
                    Gson gson = CustomGsonBuilder.getInstance().create();
                    ArrayList<LiveChannelDTO> categoryDTOS = gson.fromJson(result.toString(), new TypeToken<ArrayList<LiveChannelDTO>>() {
                    }.getType());
                    channelListAdapter.setNewList(categoryDTOS);
                    channelListAdapter.notifyDataSetChanged();
                }else {
                    noDataFound.setVisibility(View.VISIBLE);
                    noDataFound.setText("Something went wrong\nPlease try again");
                }
            }else {
                noDataFound.setVisibility(View.VISIBLE);
                noDataFound.setText("Something went wrong\nPlease try again");
            }
        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {
            progressBar.setVisibility(View.GONE);
            noDataFound.setVisibility(View.VISIBLE);
            noDataFound.setText("Server connection failed");
        }
    }
}
