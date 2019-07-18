package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity {

    TextView tvSDT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        getInit();
        getData();
    }

    void getData() {
        Intent intent = getIntent();
        String sdt = intent.getStringExtra("PHONENUMBER");
        tvSDT.setText(sdt);

    }

    void getInit() {
        tvSDT = findViewById(R.id.tv_sdt);
    }
}
