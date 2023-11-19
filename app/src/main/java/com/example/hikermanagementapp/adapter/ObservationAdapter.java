package com.example.hikermanagementapp.adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hikermanagementapp.R;
import com.example.hikermanagementapp.model.ObservationModel;

import java.util.List;

public class ObservationAdapter extends RecyclerView.Adapter<ObservationAdapter.ViewHolder> {
    private List<ObservationModel> observationList;

    public ObservationAdapter(List<ObservationModel> observationList) {
        this.observationList = observationList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView dateViewObservation, timeViewObservation, commentViewObservation;
        public ImageView imageViewProfile;

        public ViewHolder(View itemView) {
            super(itemView);
            dateViewObservation = itemView.findViewById(R.id.dateViewObservation);
            timeViewObservation = itemView.findViewById(R.id.timeViewObservation);
            commentViewObservation = itemView.findViewById(R.id.commentViewObservation);
            imageViewProfile = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_view_observation, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ObservationModel observation = observationList.get(position);
        holder.dateViewObservation.setText("" + observation.getDate());
        holder.timeViewObservation.setText("" + observation.getTime());
        holder.commentViewObservation.setText("" + observation.getComment());

        // Assuming you have a method in ContactModel to get the profile image as Bitmap
        Bitmap profileImage = observation.getProfileImage();
        if (profileImage != null) {
            holder.imageViewProfile.setImageBitmap(profileImage);
        } else {
            // If the profile image is null, you may set a default image or handle it as per your requirement
            holder.imageViewProfile.setImageResource(R.drawable.image1);
        }
    }

    @Override
    public int getItemCount() {
        return observationList.size();
    }
}
