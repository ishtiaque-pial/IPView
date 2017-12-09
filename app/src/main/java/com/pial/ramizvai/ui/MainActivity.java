package com.pial.ramizvai.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pial.ramizvai.R;
import com.pial.ramizvai.pojoClass.LoginPojo;
import com.pial.ramizvai.retrofit.Api;
import com.pial.ramizvai.util.UtilClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText userName,password;
    private Button btn;
    private Api api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.loginBtn);
        //init();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
//                    LoginPojo loginPojo = new LoginPojo();
//                    Call<LoginPojo> loginPojoCall = api.loginUser(loginPojo);
//                    loginPojoCall.enqueue(new Callback<LoginPojo>() {
//                        @Override
//                        public void onResponse(Call<LoginPojo> call, Response<LoginPojo> response) {
//                            Intent  intent = new Intent(MainActivity.this,IPListActivity.class);
//                            startActivity(intent);
//                            finish();
//                        }
//
//                        @Override
//                        public void onFailure(Call<LoginPojo> call, Throwable t) {
//                            Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
//                        }
//                    });

                    Intent  intent = new Intent(MainActivity.this,IPListActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    private void init() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(UtilClass.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }
}
