package com.example.hikermanagementapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.ArrayAdapter;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText hikeNameEditText, locationEditText, dateEditText, timeEditText,
            numberOfDaysEditText, descriptionEditText;
    private RadioGroup parkingRadioGroup;
    private RadioButton yesRadioButton, noRadioButton;
    private Spinner difficultySpinner;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    private RatingBar ratingBar;
    private Button saveButton, viewButton;
    private FloatingActionButton dateFab, timeFab;
    private String[] difficultyLevels = {"easy", "normal", "hard"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hikeNameEditText = findViewById(R.id.hikeNameEditText);
        locationEditText = findViewById(R.id.locationEditText);
        dateEditText = findViewById(R.id.dateEditText);
        timeEditText = findViewById(R.id.dateEditText2);
        numberOfDaysEditText = findViewById(R.id.numberOfDaysEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        parkingRadioGroup = findViewById(R.id.parkingRadioGroup);
        yesRadioButton = findViewById(R.id.yesRadioButton);
        noRadioButton = findViewById(R.id.noRadioButton);
        difficultySpinner = findViewById(R.id.difficultySpinner);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        ratingBar = findViewById(R.id.ratingBar);
        saveButton = findViewById(R.id.saveButton);
        viewButton = findViewById(R.id.viewButton);
        dateFab = findViewById(R.id.floatingActionButton);
        timeFab = findViewById(R.id.floatingActionButton2);

        ArrayAdapter<String> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, difficultyLevels);
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyAdapter);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ các thành phần và xử lý theo ý của bạn
                String hikeName = hikeNameEditText.getText().toString();
                String location = locationEditText.getText().toString();
                String selectedDate = dateEditText.getText().toString();
                String selectedTime = timeEditText.getText().toString();
                String numberOfDays = numberOfDaysEditText.getText().toString();
                String description = descriptionEditText.getText().toString();

                // Lấy giá trị từ RadioGroup
                int selectedParkingRadioButtonId = parkingRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedParkingRadioButton = findViewById(selectedParkingRadioButtonId);
                String parkingAvailable = selectedParkingRadioButton.getText().toString();

                // Lấy giá trị từ CheckBoxes
                boolean hasWater = checkBox1.isChecked();
                boolean hasFlashlight = checkBox2.isChecked();
                boolean hasMap = checkBox3.isChecked();
                boolean hasSnacks = checkBox4.isChecked();
                boolean hasFirstAidKit = checkBox5.isChecked();

                // Lấy giá trị từ RatingBar
                float rating = ratingBar.getRating();

                // Tạo một Intent để chuyển dữ liệu đến Activity khác
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                intent.putExtra("HikeName", hikeName);
                intent.putExtra("Location", location);
                intent.putExtra("Date", selectedDate);
                intent.putExtra("Time", selectedTime);
                intent.putExtra("NumberOfDays", numberOfDays);
                intent.putExtra("Description", description);
                intent.putExtra("ParkingAvailable", parkingAvailable);
                intent.putExtra("HasWater", hasWater);
                intent.putExtra("HasFlashlight", hasFlashlight);
                intent.putExtra("HasMap", hasMap);
                intent.putExtra("HasSnacks", hasSnacks);
                intent.putExtra("HasFirstAidKit", hasFirstAidKit);
                intent.putExtra("Rating", rating);

                // Chuyển đến Activity ViewActivity và gửi dữ liệu
                startActivity(intent);
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý khi nhấn nút View
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent);
            }
        });

        dateFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        timeFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        dateEditText.setText(selectedDate);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String selectedTime = hourOfDay + ":" + minute;
                        timeEditText.setText(selectedTime);
                    }
                }, hour, minute, true);
        timePickerDialog.show();
    }
}




