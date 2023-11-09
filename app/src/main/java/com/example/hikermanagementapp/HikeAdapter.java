package com.example.hikermanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hikermanagementapp.R;

import java.util.List;

public class HikeAdapter extends RecyclerView.Adapter<HikeAdapter.ViewHolder> {

    private List<Hike> hikes;

    public HikeAdapter(List<Hike> hikes) {
        this.hikes = hikes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hike hike = hikes.get(position);
        holder.hikeNameTextView.setText("Name of Hike: " + hike.getHikeName());
        holder.locationTextView.setText("Location: " + hike.getLocation());
        holder.dateTextView.setText("Date: " + hike.getDate());
        holder.timeTextView.setText("Time: " + hike.getTime());
        holder.daysTextView.setText("Days: " + hike.getNumberOfDays());
        holder.lengthTextView.setText("Length of Hike: " + hike.getLengthText());
        holder.descriptionTextView.setText("Description: " + hike.getDescription());

        // Hiển thị trạng thái của bãi đỗ xe (Available hoặc Not Available)
        String parkingStatus = convertParkingStatus(hike.getParking());
        holder.parkingTextView.setText("Parking: " + parkingStatus);
        holder.difficultyTextView.setText("Level: " + hike.getDifficulty());
        holder.gearTextView.setText("Required Gear: " + hike.getRequiredGear());

        holder.hikeItem.setOnClickListener(v -> {
            Bundle extras = new Bundle();
            extras.putLong("HIKE_ID", hike.getId());

            Intent intent = new Intent(v.getContext(), Edit.class);
            intent.putExtras(extras);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return hikes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CardView hikeItem;
        public TextView hikeNameTextView, locationTextView, dateTextView, timeTextView,
                daysTextView, lengthTextView, descriptionTextView, parkingTextView,
                difficultyTextView, gearTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hikeNameTextView = itemView.findViewById(R.id.viewHike);
            locationTextView = itemView.findViewById(R.id.viewLocation);
            dateTextView = itemView.findViewById(R.id.editDate);
            timeTextView = itemView.findViewById(R.id.viewTime);
            daysTextView = itemView.findViewById(R.id.viewNumber);
            lengthTextView = itemView.findViewById(R.id.viewLength);
            descriptionTextView = itemView.findViewById(R.id.viewDescription);
            parkingTextView = itemView.findViewById(R.id.viewParking);
            difficultyTextView = itemView.findViewById(R.id.viewLevel);
            gearTextView = itemView.findViewById(R.id.viewGear);

            hikeItem = itemView.findViewById(R.id.hikeItem);
            //hikeItem.setOnClickListener(v -> {
            //    Intent intent = new Intent(v.getContext(), Edit.class);
            //    v.getContext().startActivity(intent);
            //});
        }
    }

    // Phương thức chuyển đổi giá trị trường "Parking" thành "Available" hoặc "Not Available"
    private String convertParkingStatus(String parkingValue) {
        if ("1".equals(parkingValue)) {
            return "Available";
        } else if ("0".equals(parkingValue)) {
            return "Not Available";
        }
        return "";
    }
}