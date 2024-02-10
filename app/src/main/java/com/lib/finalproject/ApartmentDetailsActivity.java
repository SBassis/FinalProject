package com.lib.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ApartmentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_details);

        // Retrieve data from intent
        int id = getIntent().getIntExtra("id", 0);
        String location = getIntent().getStringExtra("location");
        double price = getIntent().getDoubleExtra("price", 0.0);
        String apartmentSpace = getIntent().getStringExtra("apartmentSpace");
        int imageResource = getIntent().getIntExtra("imageResource", 0);
        String phoneNumber = getIntent().getStringExtra("phoneNumber");

        // Initialize views
        ImageView apartmentImage = findViewById(R.id.apartmentImage);
        TextView locationTextView = findViewById(R.id.locationTextView);
        TextView priceTextView = findViewById(R.id.priceTextView);
        TextView apartmentSpaceTextView = findViewById(R.id.apartmentSpaceTextView);
        ImageView phoneIcon = findViewById(R.id.phoneIcon);
        TextView phoneNumberTextView = findViewById(R.id.phoneNumberTextView);

        // Set data to views
        apartmentImage.setImageResource(imageResource);
        locationTextView.setText(location);
        priceTextView.setText(String.valueOf(price));
        apartmentSpaceTextView.setText(apartmentSpace);
        phoneNumberTextView.setText(phoneNumber);
    }
}
