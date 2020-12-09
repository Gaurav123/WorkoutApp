package com.example.workoutapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.navigation.NavigationView;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class register extends AppCompatActivity {
    MaterialEditText name,email,password,mobile,repass;

    Button registerbtn;
    RadioGroup radioGroup;
    DBHelper DB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        repass= findViewById(R.id.repassword);
        mobile = findViewById(R.id.mobile);
        registerbtn=(Button) findViewById(R.id.register_main);
        radioGroup=findViewById(R.id.radiogp);
        DB = new DBHelper(this);


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namestr = name.getText().toString();
                String emailstr = email.getText().toString();
                String pass = password.getText().toString();
                String repassstr = repass.getText().toString();
                String mobilestr = mobile.getText().toString();

                int checkedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selected_gender = radioGroup.findViewById(checkedId);
                if (selected_gender == null){
                    Toast.makeText(register.this, "Select gender please", Toast.LENGTH_SHORT).show();}

                if(emailstr.equals("")||pass.equals("")||repassstr.equals("")||namestr.equals("")||mobilestr.equals(""))
                    Toast.makeText(register.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repassstr)){
                        Boolean checkuser = DB.checkusername(emailstr);

                        if(checkuser==false){
                            Boolean insert = DB.insertData(namestr,emailstr, pass,mobilestr);
                            if(insert==true){
                                Toast.makeText(register.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(register.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(register.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                } }
        });


    }




    }










