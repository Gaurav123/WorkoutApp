package com.example.workoutapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.HashMap;
import java.util.Map;

    public class Main3Activity_Registration extends AppCompatActivity {
        ActionBarDrawerToggle toggle;
        DrawerLayout drawerLayout;
        NavigationView nav;
        EditText email;
        EditText password;
        Button register, login;
        DBHelper DB;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main3__registration);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            email=findViewById(R.id.email);
            password=findViewById(R.id.password);
            login=findViewById(R.id.login);
            register=findViewById(R.id.register);
            DB = new DBHelper(this);

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String emailstr = email.getText().toString();
                    String pass = password.getText().toString();

                    if(emailstr.equals("")||pass.equals(""))
                        Toast.makeText(com.example.workoutapp.Main3Activity_Registration.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    else{
                        Boolean checkuserpass = DB.checkusernamepassword(emailstr, pass);
                        if(checkuserpass==true){
                            Toast.makeText(com.example.workoutapp.Main3Activity_Registration.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                            Intent intent  = new Intent(getApplicationContext(), Main2Activity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(com.example.workoutapp.Main3Activity_Registration.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });




            nav = (NavigationView) findViewById(R.id.navmenu);
            drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
            toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();

            nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()) {
                        case R.id.menu_home:
                            Toast.makeText(getApplicationContext(), "home panel is open", Toast.LENGTH_LONG).show();
                            drawerLayout.closeDrawer(GravityCompat.START);
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            break;
                        case R.id.diet:
                            Toast.makeText(getApplicationContext(), "Diet panel is open", Toast.LENGTH_LONG).show();
                            drawerLayout.closeDrawer(GravityCompat.START);
                            intent = new Intent(getApplicationContext(), dietplanmainactivity.class);
                            startActivity(intent);
                            break;
                        case R.id.rate:
                            Toast.makeText(getApplicationContext(), "Rate panel is open", Toast.LENGTH_LONG).show();
                            drawerLayout.closeDrawer(GravityCompat.START);
                            break;

                        case R.id.about:
                            Toast.makeText(getApplicationContext(), "About panel is open", Toast.LENGTH_LONG).show();
                            drawerLayout.closeDrawer(GravityCompat.START);
                            break;

                    }

                    return true;

                }


            });



        }


        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            return super.onCreateOptionsMenu(menu);

        }
        public boolean onOptionsItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.login:
                        Toast.makeText(getApplicationContext(),"Login Selected",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(Main3Activity_Registration.this, Main3Activity_Registration.class);
                        startActivity(i);
                        return true;
                    case R.id.register:
                        Toast.makeText(getApplicationContext(),"Register Selected",Toast.LENGTH_LONG).show();
                        Intent i1 = new Intent(Main3Activity_Registration.this, register.class);
                        startActivity(i1);
                        return true;
                    case R.id.trainer:
                        Toast.makeText(getApplicationContext(),"Trainer Selected Selected",Toast.LENGTH_LONG).show();
                        Intent i2 = new Intent(Main3Activity_Registration.this, trainer.class);
                        startActivity(i2);
                        return true;
                    default:
                        return super.onOptionsItemSelected(item);
                }


        }







        public void btnlogin(View view) {
            Intent intent = new Intent(getApplicationContext(), com.example.workoutapp.Main3Activity_Registration.class);
            startActivity(intent);
        }

        public void registerbtn(View view) {
            Intent intent = new Intent(this, register.class);
            startActivity(intent);
        }


    }