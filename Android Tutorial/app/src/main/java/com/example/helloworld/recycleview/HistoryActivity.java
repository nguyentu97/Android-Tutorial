package com.example.helloworld.recycleview;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.helloworld.R;
import com.example.helloworld.recycleview.model.History;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ArrayList<History> data;
    RecyclerView rvHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        init();
        prepareData();
        configRV();
    }

    private void configRV() {
        HistoryAdapter historyAdapter = new HistoryAdapter();
        historyAdapter.data = data;
        historyAdapter.context = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvHistory.setLayoutManager(linearLayoutManager);
        rvHistory.setAdapter(historyAdapter);
    }

    private void prepareData() {
        data = new ArrayList<>();
        try {
            Resources res = getResources();
            InputStream in_s = res.openRawResource(R.raw.history);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String strData = new String(b);
            JSONObject historyJson = stringToJson(strData);
            JSONArray resultJsonArray = historyJson.getJSONArray("result");
            for (int i = 0; i < resultJsonArray.length(); i++) {
                History history = new History();
                JSONObject element = resultJsonArray.getJSONObject(i);
                history.setHistoryID(element.getInt("historyID"));
                history.setCustomerID(element.getInt("customerID"));
                history.setPoint(element.getInt("point"));
                history.setTypeAdd(element.getInt("typeAdd"));
                history.setType(element.getInt("type"));
                history.setBalance(element.getInt("balance"));
                history.setCustomerName(element.getString("customerName"));
                history.setAddpointCode(element.getString("addpointCode"));
                history.setCode(element.getString("code"));
                history.setCreateDate(element.getString("createDate"));
                history.setCreateDateStr(element.getString("createDateStr"));
                history.setTitle(element.getString("title"));
                history.setIcon(element.getString("icon"));
                data.add(history);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    JSONObject stringToJson(String stringDta) {
        JSONObject historyJson;
        try {
            historyJson = new JSONObject(stringDta);
            return historyJson;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void init() {
        rvHistory = findViewById(R.id.rv_history);
    }
}
