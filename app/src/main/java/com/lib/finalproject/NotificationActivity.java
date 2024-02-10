package com.lib.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        ListView listView = findViewById(R.id.notificationListView);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        // Create data for notifications (icon IDs and notification texts)
        ArrayList<Integer> notificationIcons = new ArrayList<>();
        notificationIcons.add(R.drawable.baseline_circle_notifications_24);
        notificationIcons.add(R.drawable.baseline_circle_notifications_24);
        // Add more icons as needed
        ArrayList<String> notificationTexts = new ArrayList<>();
        notificationTexts.add(getString(R.string.notification1));
        notificationTexts.add(getString(R.string.notification2));
        // Add more notification texts as needed

        // Create and set up the adapter
        NotificationAdapter adapter = new NotificationAdapter(this, notificationIcons, notificationTexts);
        listView.setAdapter(adapter);
        //-------------------------------------------------------------------------------

        bottomNavigationView.setSelectedItemId(R.id.bottom_not);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_search:
                    startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_not:
                    return true;
                case R.id.bottom_profile:
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
            }
            return false;
        });
    }
}