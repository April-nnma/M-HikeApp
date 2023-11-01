package com.example.hikermanagementapp;

public class Hiker {
    private long id;
    private String hikeName;
    private String location;
    private String date;
    private String time;
    private int numberOfDays;
    private String description;
    private String parking;
    private String difficulty;
    private String requiredGear;
    private float rating;

    public Hiker(long id, String hikeName, String location, String date, String time, int numberOfDays, String description, String parking, String difficulty, String requiredGear, float rating) {
        this.id = id;
        this.hikeName = hikeName;
        this.location = location;
        this.date = date;
        this.time = time;
        this.numberOfDays = numberOfDays;
        this.description = description;
        this.parking = parking;
        this.difficulty = difficulty;
        this.requiredGear = requiredGear;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public String getHikeName() {
        return hikeName;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public String getDescription() {
        return description;
    }

    public String getParking() {
        return parking;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getRequiredGear() {
        return requiredGear;
    }

    public float getRating() {
        return rating;
    }
}
