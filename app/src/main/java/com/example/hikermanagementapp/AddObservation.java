//package com.example.hikermanagementapp;
//
//import android.app.Activity;
//import android.app.DatePickerDialog;
//import android.app.TimePickerDialog;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.view.View;
//import android.widget.DatePicker;
//import android.widget.EditText;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TimePicker;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import com.github.dhaval2404.imagepicker.ImagePicker;
//import java.util.Calendar;
//
//public class AddObservation extends AppCompatActivity {
//
//    private static final int REQUEST_IMAGE_CAPTURE = 101;
//
//    private ImageView imageView;
//    private EditText dateObservation;
//    private EditText timeObservation;
//    private EditText commentObservation;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_observation);
//
//        imageView = findViewById(R.id.imageView);
//        dateObservation = findViewById(R.id.dateObservation);
//        timeObservation = findViewById(R.id.timeObservation2);
//        commentObservation = findViewById(R.id.commentObservation3);
//
//        ImageButton buttonCapture = findViewById(R.id.buttonCapture);
//        buttonCapture.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showImagePicker();
//            }
//        });
//
//        dateObservation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDatePicker();
//            }
//        });
//
//        timeObservation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showTimePicker();
//            }
//        });
//
//        // Other initialization code...
//    }
//
//    private void showImagePicker() {
//        ImagePicker.Companion.with(this)
//                .crop()
//                .start();
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == ImagePicker.REQUEST_CODE && resultCode == Activity.RESULT_OK) {
//            Bitmap imageBitmap = ImagePicker.Companion.getFile(data);
//            imageView.setImageBitmap(imageBitmap);
//        }
//    }
//
//    private void showDatePicker() {
//        final Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
//                new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
//                        dateObservation.setText(selectedDate);
//                    }
//                }, year, month, day);
//
//        datePickerDialog.show();
//    }
//
//    private void showTimePicker() {
//        final Calendar calendar = Calendar.getInstance();
//        int hour = calendar.get(Calendar.HOUR_OF_DAY);
//        int minute = calendar.get(Calendar.MINUTE);
//
//        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
//                new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                        String selectedTime = hourOfDay + ":" + minute;
//                        timeObservation.setText(selectedTime);
//                    }
//                }, hour, minute, true);
//
//        timePickerDialog.show();
//    }
//
//
//    // Rest of your code...
//}
