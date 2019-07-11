package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class UpdateUserInfoActivity extends AppCompatActivity {

//    EditText edtName, edtPhone, edtDate, edtSex, edtEmail;
    RelativeLayout rlDongY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_info);
//        edtName = findViewById(R.id.edt_Ten);
//        edtPhone = findViewById(R.id.edt_Phone);
//        edtDate = findViewById(R.id.edt_Date);
//        edtSex = findViewById(R.id.edt_Sex);
//        edtEmail = findViewById(R.id.edt_Mail);

        init();
        getData();


        rlDongY = findViewById(R.id.rl_Dong_Y);
        rlDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateUserInfoActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

    }

    void getData(){

    }

    void init(){



    }

    public void Back(View view) {
        finish();
    }
}
