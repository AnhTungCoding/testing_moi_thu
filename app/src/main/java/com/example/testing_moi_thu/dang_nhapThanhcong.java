package com.example.testing_moi_thu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class dang_nhapThanhcong extends AppCompatActivity {
    TextView dnThanhcong_welcometext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap_thanhcong);
        dnThanhcong_welcometext.findViewById(R.id.dnThanhcong_welcometext);

        String emailDN;
        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                emailDN = null;
            } else {
                emailDN = extras.getString("email");
            }
        }else {
            emailDN = (String) savedInstanceState.getSerializable("email");
        }
        dnThanhcong_welcometext.setText("xin chao" + emailDN);


    }
}