package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView tvName,tvSDT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        User user = (User)intent.getSerializableExtra("USER");
        tvName.setText(user.name);
        tvSDT.setText("("+user.phoneNumeber+")");
    }

    private void init() {
        tvName = findViewById(R.id.tv_name);
        tvSDT = findViewById(R.id.tv_sdt);
    }

}
