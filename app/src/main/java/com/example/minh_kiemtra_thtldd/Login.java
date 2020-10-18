package com.example.minh_kiemtra_thtldd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText mEmail,mPassword;
    Button mLoginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmail=findViewById(R.id.editTextTextPersonName);
        mPassword=findViewById(R.id.editTextTextPassword);
        mLoginBtn=findViewById(R.id.loginButton);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mEmail.getText().length()!=0 &&mPassword.getText().length()!=0)
                {
                    if ( mEmail.getText().toString().equals("trananhminh") && mPassword.getText().toString().equals("123"))
                    {
                        Toast.makeText(Login.this,"Đăng nhập thành công!",Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(Login.this,Listview.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(Login.this,"Đăng nhập thất bại!",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(Login.this,"Nhập đủ thông tin!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}