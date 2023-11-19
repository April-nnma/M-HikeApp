package com.example.hikermanagementapp.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class ObservationModel implements Parcelable {
    private String date;
    private String time;
    private String comment;
    private Bitmap profileImage;

    public ObservationModel(String date, String time, String comment, Bitmap profileImage) {
        this.date = date;
        this.time = time;
        this.comment = comment;
        this.profileImage = profileImage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Bitmap getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Bitmap profileImage) {
        this.profileImage = profileImage;
    }

    // Parcelable implementation
    protected ObservationModel(Parcel in) {
        date = in.readString();
        time = in.readString();
        comment = in.readString();
        profileImage = in.readParcelable(Bitmap.class.getClassLoader());
    }
    public static final Creator<ObservationModel> CREATOR = new Creator<ObservationModel>() {
        @Override
        public ObservationModel createFromParcel(Parcel in) {
            return new ObservationModel(in);
        }

        @Override
        public ObservationModel[] newArray(int size) {
            return new ObservationModel[size]; // Fix: Use [] instead of [][size]
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(time);
        dest.writeString(comment);
        dest.writeParcelable(profileImage, flags);
    }
}
