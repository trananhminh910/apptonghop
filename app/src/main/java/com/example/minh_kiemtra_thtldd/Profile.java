package com.example.minh_kiemtra_thtldd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView mLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        mLogout=findViewById(R.id.logout);

        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Profile.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}