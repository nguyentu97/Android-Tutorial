package com.example.helloworld.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.helloworld.R;
import com.example.helloworld.recycleview.model.UserfullName;
import com.example.helloworld.recycleview.model.UserfullNameResponse;
import com.example.helloworld.recycleview.network.RetrofitClient;
import com.example.helloworld.recycleview.network.ServiceAPI;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserfullNameActivity extends AppCompatActivity {

    RecyclerView rvUserfullName;
    ArrayList<UserfullName> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userfull_name);
        init();
        getData();
    }

    private void init() {
        rvUserfullName = findViewById(R.id.rv_user_full_name);
    }

    private void getData() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("contactID",0);
            jsonObject.put("searchKey","");
        } catch (Exception e) {
            e.printStackTrace();
        }
        RetrofitClient.getRetrofit().create(ServiceAPI.class).getListUserfullName(jsonObject).enqueue(new Callback<UserfullNameResponse>() {
            @Override
            public void onResponse(Call<UserfullNameResponse> call, Response<UserfullNameResponse> response) {
                data.addAll(response.body().result);
                configRV();
                Log.d("", "onResponse: ");
            }

            @Override
            public void onFailure(Call<UserfullNameResponse> call, Throwable t) {
                Log.d("", "onResponse: ");
            }
        });
    }

    private void configRV() {
        UserfullPhoneAdapter userfullPhoneAdapter = new UserfullPhoneAdapter(this,data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,linearLayoutManager.getOrientation());
        rvUserfullName.addItemDecoration(dividerItemDecoration);
        rvUserfullName.setLayoutManager(linearLayoutManager);
        rvUserfullName.setAdapter(userfullPhoneAdapter);
    }
}
