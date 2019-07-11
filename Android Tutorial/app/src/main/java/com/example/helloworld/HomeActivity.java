package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView txtName;
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
        txtName.setText(user.name);
    }

    private void init() {
        txtName = findViewById(R.id.tv_name);
    }

}
