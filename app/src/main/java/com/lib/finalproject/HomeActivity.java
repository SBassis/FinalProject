package com.lib.finalproject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Apartment> apartmentList;
    private ApartmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);

            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            // Initialize apartment list
            apartmentList = new ArrayList<>();
            // Add sample apartments
            apartmentList.add(new Apartment(1, "Birziet", 900, "100 m", R.drawable.apartment1, "059-1234-5678"));
            apartmentList.add(new Apartment(2, "Birziet, Surda", 900, "100 m", R.drawable.apartment5, "059-1234-5678"));

        // Add more apartments as needed

            // Initialize and set adapter
            adapter = new ApartmentAdapter(apartmentList, this);
            recyclerView.setAdapter(adapter);



        //////////////////////////////////////////////////////////////////////////////
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    return true;
                case R.id.bottom_search:
                    startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    return true;
                case R.id.bottom_not: //notification
                    startActivity(new Intent(getApplicationContext(), NotificationActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    return true;
                case R.id.bottom_profile:
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    return true;
            }
            return false;
        });
    }
}