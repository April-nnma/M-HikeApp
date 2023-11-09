package com.example.hikermanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class Edit extends AppCompatActivity {
    private EditText editHike, editLocation, editDate, editTime, editNumber, editLength, editDescription, editGear;
    private RadioButton yesRadioButton, noRadioButton;
    private Spinner difficultySpinner;
    private Button updateButton, deleteButton;
    private DatabaseHelper databaseHelper;
    private long hikeId;
    private String[] difficultyLevels = {"easy", "normal", "hard"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editHike = findViewById(R.id.editHike);
        editLocation = findViewById(R.id.editLocation);
        editDate = findViewById(R.id.editDate);
        editTime = findViewById(R.id.editTime);
        editNumber = findViewById(R.id.editNumber);
        editLength = findViewById(R.id.editLength);
        editDescription = findViewById(R.id.editDescription);
        editGear = findViewById(R.id.editGear);
        yesRadioButton = findViewById(R.id.yesRadioButton);
        noRadioButton = findViewById(R.id.noRadioButton);
        difficultySpinner = findViewById(R.id.difficultySpinner);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);

        databaseHelper = new DatabaseHelper(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            hikeId = extras.getLong("HIKE_ID");
            Hike hike = databaseHelper.getAllHikes().get((int) hikeId);
            if (hike != null) {
                editHike.setText(hike.getHikeName());
                editLocation.setText(hike.getLocation());
                editDate.setText(hike.getDate());
                editTime.setText(hike.getTime());
                editNumber.setText(String.valueOf(hike.getNumberOfDays()));
                editLength.setText(hike.getLengthText());

                editDescription.setText(hike.getDescription());
                editGear.setText(hike.getRequiredGear());
                if ("1".equals(hike.getParking())) {
                    yesRadioButton.setChecked(true);
                } else {
                    noRadioButton.setChecked(true);
                }

                //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, difficultyLevels, android.R.layout.simple_spinner_item);
                //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //difficultySpinner.setAdapter(adapter);

                ArrayAdapter<String> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, difficultyLevels);
                difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                difficultySpinner.setAdapter(difficultyAdapter);

                if (hike.getDifficulty() != null) {
                    int spinnerPosition = difficultyAdapter.getPosition(hike.getDifficulty());
                    difficultySpinner.setSelection(spinnerPosition);
                }
            }
        }
    }
}