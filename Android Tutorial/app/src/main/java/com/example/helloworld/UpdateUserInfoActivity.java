package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class UpdateUserInfoActivity extends AppCompatActivity {

    RelativeLayout rlDongY;
    EditText edtPhone, edtName, edtDOB, edtProvice, edtMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_info);

        init();
        getData();

    }

    void prepareData() {

        //Tao doi tuong user
        User user;

        //Lay gia tri nguoi dung nhao vao
        String name = edtName.getText().toString();
        String phone = edtPhone.getText().toString();
        String DOB = edtDOB.getText().toString();
        String provice = edtProvice.getText().toString();
        String mail = edtMail.getText().toString();


        //Gan gia tri

        user = new User(name,phone,DOB,provice,mail);


        Intent intent = new Intent(UpdateUserInfoActivity.this, HomeActivity.class);
        intent.putExtra("USER",user);
        startActivity(intent);

    }


    void getData() {
        Intent intent = getIntent();
        String phoneNumber = intent.getStringExtra("PHONENUMBER");
        edtPhone.setText(phoneNumber);
    }

    void init() {
        edtPhone = findViewById(R.id.edt_phone);
        edtName = findViewById(R.id.edt_ten);
        edtDOB = findViewById(R.id.edt_date);
        edtProvice = findViewById(R.id.edt_provice);
        edtMail = findViewById(R.id.edt_mail);
        rlDongY = findViewById(R.id.rl_dong_y);
        rlDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareData();
            }
        });
    }

    public void Back(View view) {
        finish();
    }
}
