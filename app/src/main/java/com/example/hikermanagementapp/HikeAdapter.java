package com.example.hikermanagementapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HikeAdapter extends RecyclerView.Adapter<HikeAdapter.ViewHolder> {

    private List<Hike> hikes;

    public HikeAdapter(List<Hike> hikes) {
        this.hikes = new ArrayList<>(hikes); // Initialize full list with original data
    }

    public void UpdateList(List<Hike> hikes) {
        this.hikes = new ArrayList<>(hikes); // Initialize full list with original data

        notifyDataSetChanged();
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

        holder.hikeId.setText(String.valueOf(hike.getId()));
    }

    @Override
    public int getItemCount() {
        return hikes.size();
    }

//    @Override
//    public Filter getFilter() {
//        return hikeFilter;
//    }

//    private Filter hikeFilter = new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            List<Hike> filteredList = new ArrayList<>();
//
//            if (constraint == null || constraint.length() == 0) {
//                filteredList.addAll(hikes);
//            } else {
//                String filterPattern = constraint.toString().toLowerCase().trim();
//
//                for (Hike hike : hikes) {
//                    if (hike.getHikeName().toLowerCase().contains(filterPattern)
//                            || hike.getLocation().toLowerCase().contains(filterPattern)) {
//                        filteredList.add(hike);
//                    }
//                }
//            }
//
//            FilterResults results = new FilterResults();
//            results.values = filteredList;
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            hikes.clear();
//            hikes.addAll((List) results.values);
//            notifyDataSetChanged();
//        }
//    };

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView hikeNameTextView, locationTextView, dateTextView, timeTextView,
                daysTextView, lengthTextView, descriptionTextView, parkingTextView,
                difficultyTextView, gearTextView, hikeId;

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
            hikeId = itemView.findViewById(R.id.itemViewHikeId);

            itemView.setOnClickListener(v -> {
                int adapterPosition = getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    Hike clickedHike = hikes.get(adapterPosition);
                    Bundle extras = new Bundle();
                    extras.putLong("HIKE_ID", clickedHike.getId());

                    Intent intent = new Intent(v.getContext(), EditActivity.class);
                    intent.putExtras(extras);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    private String convertParkingStatus(String parkingValue) {
        if ("1".equals(parkingValue)) {
            return "Available";
        } else if ("0".equals(parkingValue)) {
            return "Not Available";
        }
        return "";
    }
}
