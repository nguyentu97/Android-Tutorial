package com.example.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView tvName,tvSDT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        //getData();
    }

    private void getData() {
        Intent intent = getIntent();
        User user = (User)intent.getSerializableExtra("USER");
        tvName.setText(user.name);
        tvSDT.setText("("+user.phoneNumeber+")");
        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               finish();

            }
        });
    }

    private void init() {
        tvName = findViewById(R.id.tv_name);
        tvSDT = findViewById(R.id.tv_sdt);
    }

}
