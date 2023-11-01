package com.example.hikermanagementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "hike_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_HIKES = "hikes";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_HIKE_NAME = "hike_name";
    private static final String COLUMN_LOCATION = "location";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_NUMBER_OF_DAYS = "number_of_days";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_PARKING = "parking";
    private static final String COLUMN_DIFFICULTY = "difficulty";
    private static final String COLUMN_REQUIRED_GEAR = "required_gear";
    private static final String COLUMN_RATING = "rating";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_HIKES + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_HIKE_NAME + " TEXT, " +
                COLUMN_LOCATION + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_TIME + " TEXT, " +
                COLUMN_NUMBER_OF_DAYS + " INTEGER, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_PARKING + " TEXT, " +
                COLUMN_DIFFICULTY + " TEXT, " +
                COLUMN_REQUIRED_GEAR + " TEXT, " +
                COLUMN_RATING + " REAL" +
                ")";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xử lý khi có sự thay đổi phiên bản cơ sở dữ liệu (nếu cần)
    }

    public long addHike(Hiker hike) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_HIKE_NAME, hike.getHikeName());
        values.put(COLUMN_LOCATION, hike.getLocation());
        values.put(COLUMN_DATE, hike.getDate());
        values.put(COLUMN_TIME, hike.getTime());
        values.put(COLUMN_NUMBER_OF_DAYS, hike.getNumberOfDays());
        values.put(COLUMN_DESCRIPTION, hike.getDescription());
        values.put(COLUMN_PARKING, hike.getParking());
        values.put(COLUMN_DIFFICULTY, hike.getDifficulty());
        values.put(COLUMN_REQUIRED_GEAR, hike.getRequiredGear());
        values.put(COLUMN_RATING, hike.getRating());

        long newRowId = db.insert(TABLE_HIKES, null, values);
        db.close();
        return newRowId;
    }

    public List<Hiker> getAllHikes() {
        List<Hiker> hikes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {
                COLUMN_ID, COLUMN_HIKE_NAME, COLUMN_LOCATION,
                COLUMN_DATE, COLUMN_TIME, COLUMN_NUMBER_OF_DAYS,
                COLUMN_DESCRIPTION, COLUMN_PARKING, COLUMN_DIFFICULTY,
                COLUMN_REQUIRED_GEAR, COLUMN_RATING
        };
        Cursor cursor = db.query(TABLE_HIKES, projection, null, null, null, null, null);

        while (cursor.moveToNext()) {
            long hikeId = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID));
            String hikeName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_HIKE_NAME));
            String location = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LOCATION));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE));
            String time = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TIME));
            int numberOfDays = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_NUMBER_OF_DAYS));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION));
            String parking = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PARKING));
            String difficulty = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DIFFICULTY));
            String requiredGear = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REQUIRED_GEAR));
            float rating = cursor.getFloat(cursor.getColumnIndexOrThrow(COLUMN_RATING));

            Hiker hike = new Hiker(hikeId, hikeName, location, date, time, numberOfDays, description, parking, difficulty, requiredGear, rating);
            hikes.add(hike);
        }

        cursor.close();
        db.close();
        return hikes;
    }

    public void deleteHike(long hikeId) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(hikeId)};
        db.delete(TABLE_HIKES, selection, selectionArgs);
        db.close();
    }
}
