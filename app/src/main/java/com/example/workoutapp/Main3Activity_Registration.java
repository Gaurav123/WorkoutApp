package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity_Registration extends AppCompatActivity {

        EditText username, password, repassword;
        Button signup, signin;
        DBHelper DB;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            username = (EditText) findViewById(R.id.username);
            password = (EditText) findViewById(R.id.password);
            repassword = (EditText) findViewById(R.id.repassword);
            signup = (Button) findViewById(R.id.btnsignup);
            signin = (Button) findViewById(R.id.btnsignin);
            DB = new DBHelper(this);

            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = username.getText().toString();
                    String email = password.getText().toString();
                    String pass = username.getText().toString();
                    String repass = password.getText().toString();
                    String mobile = repassword.getText().toString();

                    if(email.equals("")||pass.equals("")||repass.equals(""))
                        Toast.makeText(Main3Activity_Registration.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    else{
                        if(pass.equals(repass)){
                            Boolean checkuser = DB.checkusername(email);
                            if(checkuser==false){
                                Boolean insert = DB.insertData(name,email, pass,mobile);
                                if(insert==true){
                                    Toast.makeText(Main3Activity_Registration.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(Main3Activity_Registration.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(Main3Activity_Registration.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(Main3Activity_Registration.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                        }
                    } }
            });

            signin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), activity_login.class);
                    startActivity(intent);
                }
            });
        }
    }
