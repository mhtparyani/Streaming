package com.shera.internexttv;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.hmomeni.progresscircula.ProgressCircula;
import com.shera.internexttv.controller.Controller;
import com.shera.internexttv.utils.Constant;
import com.shera.internexttv.utils.Utils;
import com.shera.internexttv.view.channel.ChannelListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.username_et)
    TextInputEditText usernameEt;
    @BindView(R.id.username_tl)
    TextInputLayout usernameTl;
    @BindView(R.id.password_et)
    TextInputEditText passwordEt;
    @BindView(R.id.password_tl)
    TextInputLayout passwordTl;
    @BindView(R.id.login_bt)
    Button loginBt;
    @BindView(R.id.progressBar)
    ProgressCircula progressBar;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Utils.setTextChangeListener(usernameTl, usernameEt);
        Utils.setTextChangeListener(passwordTl, passwordEt);
        progressBar.setVisibility(View.GONE);
        sharedPreferences = getSharedPreferences(Constant.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!usernameEt.getText().toString().isEmpty()) {
                    if (!passwordEt.getText().toString().isEmpty()) {
                        usernameEt.setEnabled(false);
                        passwordEt.setEnabled(false);
                        loginBt.setEnabled(false);
                        progressBar.setVisibility(View.VISIBLE);
                        Controller controller = Controller.getInstance(LoginActivity.this);
                        controller.login(usernameEt.getText().toString(), passwordEt.getText().toString(), new LoginResponse());
                    } else {
                        Utils.setError(passwordTl, "Please enter password.");
                    }
                } else {
                    Utils.setError(usernameTl, "Please enter username.");
                }
            }
        });
    }

    private class LoginResponse implements Callback<ResponseBody> {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            if (response.body()!=null){
                if (response.isSuccessful()) {
                    sharedPreferences.edit().putString(Constant.USER_KEY,usernameEt.getText().toString()).apply();
                    sharedPreferences.edit().putString(Constant.PASS_KEY,passwordEt.getText().toString()).apply();
                    Intent i= new Intent(LoginActivity.this, ChannelListActivity.class);
                    startActivity(i);
                    finish();
                }else {
                    progressBar.setVisibility(View.GONE);
                    usernameEt.setEnabled(true);
                    passwordEt.setEnabled(true);
                    loginBt.setEnabled(true);
                    Toast.makeText(LoginActivity.this, "Invalid credentials\nPlease try again", Toast.LENGTH_SHORT).show();
                }
            }else {
                progressBar.setVisibility(View.GONE);
                usernameEt.setEnabled(true);
                passwordEt.setEnabled(true);
                loginBt.setEnabled(true);
                Toast.makeText(LoginActivity.this, "Something went wrong\nPlease try again", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {
            progressBar.setVisibility(View.GONE);
            usernameEt.setEnabled(true);
            passwordEt.setEnabled(true);
            loginBt.setEnabled(true);
            Toast.makeText(LoginActivity.this, "Server connection failed", Toast.LENGTH_LONG).show();
        }
    }
}
