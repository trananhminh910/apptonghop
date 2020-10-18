package com.example.minh_kiemtra_thtldd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mLoginBtn;
    Button mSignupBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        mLoginBtn=findViewById(R.id.login_index);
        mSignupBtn=findViewById(R.id.signup_index);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });

        mSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,Signup.class);
                startActivity(intent);
            }
        });
    }
}