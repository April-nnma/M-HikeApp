//package com.example.hikermanagementapp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.RadioButton;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class DeleteActivity extends AppCompatActivity {
//    private EditText editHike, editLocation, editDate, editTime, editNumber, editLength, editDescription, editGear;
//    private RadioButton yesRadioButton, noRadioButton;
//    private Spinner difficultySpinner;
//    private Button deleteButton;
//    private DatabaseHelper databaseHelper;
//    private long hikeId;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit);
//
//        deleteButton = findViewById(R.id.deleteButton);
//        databaseHelper = new DatabaseHelper(this);
//
//        Intent intent = getIntent();
//        hikeId = intent.getLongExtra("HikeId", -1);
//        deleteButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (hikeId != -1) {
//                    databaseHelper.deleteHike(hikeId);
//                    finish();
//                } else {
//                    Toast.makeText(DeleteActivity.this, "Can't delete", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//}
