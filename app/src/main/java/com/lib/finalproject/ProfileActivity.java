package com.lib.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    TextView nameTxt, usernameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize TextViews
        nameTxt = findViewById(R.id.nameTxt);
        usernameTxt = findViewById(R.id.usernameTxt);

        // Retrieve data from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String username = sharedPreferences.getString("username", "");

        // Update TextViews with retrieved data
        nameTxt.setText(name);
        usernameTxt.setText(username);


        ////////////////////////////////////////////////
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_profile);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    return true;
                case R.id.bottom_search:
                    startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    return true;
                case R.id.bottom_not:
                    startActivity(new Intent(getApplicationContext(), NotificationActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    return true;
                case R.id.bottom_profile:
                    return true;
            }
            return false;
        });
    }
}