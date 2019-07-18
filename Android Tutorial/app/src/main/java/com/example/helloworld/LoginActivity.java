package com.example.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    void init() {
        //Khai bao cho no biet dau la cai textView co chu hello
        TextView tvHello, tvLogin, tvLogin1, tvLoginPhoneNumber, tvSocialLogin;
        RelativeLayout rlLoginButton;
        //Khoi tao lien ket voi XML
        tvHello = findViewById(R.id.tv_hello);
        tvHello.setText("Hello");
        final EditText edt_phone_number;
        edt_phone_number = findViewById(R.id.edt_phone_number);
//        edt_phone_number.setText("0961159346");

        tvLogin = findViewById(R.id.tv_login);
        tvLogin1 = findViewById(R.id.tv_login_1);
        tvLoginPhoneNumber = findViewById(R.id.tv_login_phone_number);
        tvSocialLogin = findViewById(R.id.tv_social_login);
        rlLoginButton = findViewById(R.id.rl_login_button);

        tvLogin.setText("Login");
        tvLogin1.setText("Login");
        tvLoginPhoneNumber.setText("Login with phone Number");
        tvSocialLogin.setText("Social Login");
        rlLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = edt_phone_number.getText().toString();
                int phoneNumberLength = phoneNumber.length();
                if (phoneNumberLength > 9) {
                    Toast.makeText(LoginActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent;
                    intent = new Intent(LoginActivity.this, UpdateUserInfoActivity.class);
//                    intent = new Intent(LoginActivity.this, AccountActivity.class);
                    //startActivity(intent);
                    //Them du lieu vao trong intent(nhet)
                    intent.putExtra("PHONENUMBER",phoneNumber);
                    intent.putExtra("name","NguyenTu");
                    //Luu trang thai dang nhap
                    setLogin();
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Nhap sai moi nhap lai", Toast.LENGTH_SHORT).show();
                    edt_phone_number.setText("");
                }
//                edt_phone_number.setText("");
//                Toast.makeText(LoginActivity.this, "Nut hong nha!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    void setLogin(){
        //B1 Tao file
        SharedPreferences sharedPreferences = getSharedPreferences("dekko",MODE_PRIVATE);
        //B2 Sua, goi phan mem sua
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putBoolean("isLogin",true);
        editor.apply();
    }
    //hello
}
