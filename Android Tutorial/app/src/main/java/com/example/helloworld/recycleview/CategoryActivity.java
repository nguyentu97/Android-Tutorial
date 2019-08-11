package com.example.helloworld.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.helloworld.R;
import com.example.helloworld.recycleview.model.Category;
import com.example.helloworld.recycleview.model.ListCategoryResponse;
import com.example.helloworld.recycleview.network.RetrofitClient;
import com.example.helloworld.recycleview.network.ServiceAPI;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {

    RecyclerView rvCategory;
    ArrayList<Category> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        init();
        getData();
    }

    private void init() {
        rvCategory = findViewById(R.id.rv_category);
    }

    private void getData() {
        RetrofitClient.getRetrofit().create(ServiceAPI.class).getListCategory().enqueue(new Callback<ListCategoryResponse>() {
            @Override
            public void onResponse(Call<ListCategoryResponse> call, Response<ListCategoryResponse> response) {
                data.addAll(response.body().result.listCate);
                configRV();
                Log.d("", "onResponse: ");
            }

            @Override
            public void onFailure(Call<ListCategoryResponse> call, Throwable t) {
                Log.d("", "onResponse: ");
            }
        });
    }

    private void configRV() {
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, data);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        rvCategory.setLayoutManager(gridLayoutManager);
        rvCategory.setAdapter(categoryAdapter);
    }
}
