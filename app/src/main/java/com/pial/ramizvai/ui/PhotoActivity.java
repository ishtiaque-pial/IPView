package com.pial.ramizvai.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.pial.ramizvai.R;
import com.pial.ramizvai.adapter.IpAdapter;
import com.pial.ramizvai.adapter.PhotoAdapter;
import com.pial.ramizvai.pojoClass.PhotoPojo;
import com.pial.ramizvai.retrofit.Api;
import com.pial.ramizvai.util.UtilClass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotoActivity extends AppCompatActivity {
    private RecyclerView recyclerViewPhoto;
    private Api api;
    private RecyclerView.LayoutManager layoutManager;
    private PhotoAdapter photoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        recyclerViewPhoto = findViewById(R.id.recyclerViewPhoto);
        init();
        Call<ArrayList<PhotoPojo>> arrayListCall = api.photoUrlPojo();
        arrayListCall.enqueue(new Callback<ArrayList<PhotoPojo>>() {
            @Override
            public void onResponse(Call<ArrayList<PhotoPojo>> call, Response<ArrayList<PhotoPojo>> response) {
                if (!response.body().isEmpty()) {
                    recyclerViewPhoto.setHasFixedSize(true);
                    layoutManager =new LinearLayoutManager(PhotoActivity.this);
                    recyclerViewPhoto.setLayoutManager(layoutManager);
                    photoAdapter = new PhotoAdapter(response.body(),getApplicationContext());
                    recyclerViewPhoto.setAdapter(photoAdapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<PhotoPojo>> call, Throwable t) {
                Toast.makeText(PhotoActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
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
