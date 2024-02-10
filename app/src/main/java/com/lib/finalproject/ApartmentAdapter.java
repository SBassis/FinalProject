package com.lib.finalproject;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ApartmentAdapter extends RecyclerView.Adapter<ApartmentAdapter.ViewHolder> {

    private List<Apartment> apartmentList;
    private Context context;

    public ApartmentAdapter(List<Apartment> apartmentList, Context context) {
        this.apartmentList = apartmentList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Apartment apartment = apartmentList.get(position);
        holder.apartmentLocation.setText(apartment.getLocation());
        holder.apartmentImage.setImageResource(apartment.getImageResource());

        holder.btnView.setOnClickListener(v -> {
            // Handle View button click
            Intent intent = new Intent(context, ApartmentDetailsActivity.class);
            intent.putExtra("id", apartment.getId());
            intent.putExtra("location", apartment.getLocation());
            intent.putExtra("price", apartment.getPrice());
            intent.putExtra("apartmentSpace", apartment.getApartmentSpace());
            intent.putExtra("imageResource", apartment.getImageResource());
            intent.putExtra("phoneNumber", apartment.getPhoneNumber());
            context.startActivity(intent);

          //  Toast.makeText(context, "View button clicked for " + apartment.getLocation(), Toast.LENGTH_SHORT).show();
        });

        holder.btnEvaluate.setOnClickListener(v -> {
            // Handle Evaluate button click
            Toast.makeText(context, "Evaluate button clicked for " + apartment.getLocation(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return apartmentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView apartmentImage;
        TextView apartmentLocation;
        Button btnView, btnEvaluate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            apartmentImage = itemView.findViewById(R.id.apartmentImage);
            apartmentLocation = itemView.findViewById(R.id.apartmentLocation);
            btnView = itemView.findViewById(R.id.btnView);
            btnEvaluate = itemView.findViewById(R.id.btnEvaluate);
        }
    }
}