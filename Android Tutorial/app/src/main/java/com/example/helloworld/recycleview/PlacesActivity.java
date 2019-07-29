package com.example.helloworld.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.helloworld.R;
import com.example.helloworld.Util.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PlacesActivity extends AppCompatActivity {

    RecyclerView rvPlace;
    ArrayList<Places> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        init();
        prepareData();
        configRV();
    }

    private void configRV() {
        //cach viet 1:
        PlacesAdapter placesAdapter = new PlacesAdapter(this,data);
        //cach viet 2:
//        PlacesAdapter placesAdapter = new PlacesAdapter();
//        placesAdapter.data = data;
//        placesAdapter.context = this;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,linearLayoutManager.getOrientation());
        rvPlace.addItemDecoration(dividerItemDecoration);
        rvPlace.setLayoutManager(linearLayoutManager);
        rvPlace.setAdapter(placesAdapter);
    }

    private void prepareData() {
        JSONObject jsonObject = Util.filetoJson(R.raw.places,this);
        try {
            JSONArray jsonArray = jsonObject.getJSONArray("result");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject element = jsonArray.getJSONObject(i);
                String namePlaces = element.getString("placeName");
                int isMoreDetail = element.getInt("isMoreDetail");
                int isPromotion = element.getInt("isPromotion");
                Places places = new Places(namePlaces,isMoreDetail,isPromotion);
                data.add(places);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        rvPlace = findViewById(R.id.rv_places);
    }
}
