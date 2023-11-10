package com.example.hikermanagementapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HikeAdapter hikeAdapter;
    private DatabaseHelper dbHelper;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_hike);

        dbHelper = new DatabaseHelper(this);
        List<Hike> hikes = dbHelper.getAllHikes();

        recyclerView = findViewById(R.id.RVhike);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        hikeAdapter = new HikeAdapter(hikes);
        recyclerView.setAdapter(hikeAdapter);

        // Initialize SearchView
//
    }

    @Override
    protected void onResume() {
        super.onResume();
        reloadList();
    }

    public void reloadList() {
        List<Hike> hikes = dbHelper.getAllHikes();

        hikeAdapter.UpdateList(hikes);
    }
}
