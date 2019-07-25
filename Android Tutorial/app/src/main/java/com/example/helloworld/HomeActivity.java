package com.example.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

public class HomeActivity extends AppCompatActivity {

    TextView tvName,tvSDT,tvPoint,tvTitle1,tvTitle2,tvTitle3,tvTitle11,tvTitle22,tvTitle33;
    ImageView imgNews1,imgNews2,imgNews3,imgPromotion1,imgPromotion2,imgPromotion3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        getData();
    }

    private void getData() {
        try {
            Resources res = getResources();
            InputStream in_s = res.openRawResource(R.raw.home);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String strData = new String(b);
            JSONObject homeJson = stringToJson(strData);

            JSONObject resultJson = homeJson.getJSONObject("result");
            JSONObject cusDetail = resultJson.getJSONObject("customerDetail");

            String phone = cusDetail.getString("phone");
            String name = cusDetail.getString("customerName");
            int point  = cusDetail.getInt("point");


            tvName.setText(name);
            tvSDT.setText("("+phone+")");
            tvPoint.setText(point+"");

            //Json listNews
            JSONArray listNewJson = resultJson.getJSONArray("listNews");
            JSONObject firstJson = listNewJson.getJSONObject(0);
            String title = firstJson.getString("title");
            tvTitle1.setText(title);
            String url = firstJson.getString("urlImage");
            Picasso.get().load(url).into(imgNews1);

            JSONObject secondJson = listNewJson.getJSONObject(1);
            title = secondJson.getString("title");
            tvTitle2.setText(title);
            url = secondJson.getString("urlImage");
            Picasso.get().load(url).into(imgNews2);

            JSONObject thirdJson = listNewJson.getJSONObject(2);
            title = thirdJson.getString("title");
            tvTitle3.setText(title);
            url = thirdJson.getString("urlImage");
            Picasso.get().load(url).into(imgNews3);

            // Json listPromotion
            JSONArray listPromotionJson = resultJson.getJSONArray("listPromotion");
            firstJson = listPromotionJson.getJSONObject(0);
            title = firstJson.getString("title");
            url = firstJson.getString("urlImage");
            tvTitle11.setText(title);
            Picasso.get().load(url).into(imgPromotion1);

            secondJson = listPromotionJson.getJSONObject(1);
            title = secondJson.getString("title");
            url = secondJson.getString("urlImage");
            tvTitle22.setText(title);
            Picasso.get().load(url).into(imgPromotion2);



        } catch (Exception e) {
             e.printStackTrace();
        }
    }

    JSONObject stringToJson(String stringDta){
        JSONObject homeJson;
        try {
            homeJson =  new JSONObject(stringDta);
            return homeJson;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void init() {
        tvName = findViewById(R.id.tv_name);
        tvSDT = findViewById(R.id.tv_sdt);
        tvPoint = findViewById(R.id.tv_point);
        tvTitle1 = findViewById(R.id.tv_title1);
        tvTitle2 = findViewById(R.id.tv_title2);
        tvTitle3 = findViewById(R.id.tv_title3);
        imgNews1 = findViewById(R.id.img_news1);
        imgNews2 = findViewById(R.id.img_news2);
        imgNews3 = findViewById(R.id.img_news3);

        tvTitle11 = findViewById(R.id.tv_title11);
        tvTitle22 = findViewById(R.id.tv_title22);
        tvTitle33 = findViewById(R.id.tv_title33);
        imgPromotion1 = findViewById(R.id.img_promotion1);
        imgPromotion2 = findViewById(R.id.img_promotion2);
        imgPromotion3 = findViewById(R.id.img_promotion3);

    }

}
