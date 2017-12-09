package com.pial.ramizvai.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.pial.ramizvai.R;
import com.pial.ramizvai.adapter.IpAdapter;
import com.pial.ramizvai.listener.clickListener;
import com.pial.ramizvai.pojoClass.UrlPojo;
import com.pial.ramizvai.retrofit.Api;
import com.pial.ramizvai.util.UtilClass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IPListActivity extends AppCompatActivity implements clickListener {

    private RecyclerView recyclerView;
    private Api api;
    private RecyclerView.LayoutManager layoutManager;
    private IpAdapter ipAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iplist);
        recyclerView = findViewById(R.id.recyclerView);
        initi();

        Call<ArrayList<UrlPojo>> arrayListCall = api.urlPojo();
        arrayListCall.enqueue(new Callback<ArrayList<UrlPojo>>() {
            @Override
            public void onResponse(Call<ArrayList<UrlPojo>> call, Response<ArrayList<UrlPojo>> response) {
                if (!response.body().isEmpty()) {
                    recyclerView.setHasFixedSize(true);
                    layoutManager =new LinearLayoutManager(IPListActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    ipAdapter = new IpAdapter(response.body(),IPListActivity.this);
                    recyclerView.setAdapter(ipAdapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<UrlPojo>> call, Throwable t) {
                Toast.makeText(IPListActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initi() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(UtilClass.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.action_settings) {
            startActivity(new Intent(this,PhotoActivity.class));
        }
        return true;
    }

    @Override
    public void onClik(String url) {
        Intent mIntent = new Intent(this, WebActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putString("url", url);
        mIntent.putExtras(mBundle);
        startActivity(mIntent);

    }
}
