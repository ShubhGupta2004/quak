package com.example.quak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a fake list of earthquake locations.
        ArrayList<earthQuakeData> earthquakes = QueryUtils.extractEarthquakes();

        earthquakes.add(new earthQuakeData("san fransisco","Alaska","7.1","WED 27 May 2022","03:00 PM","https://www.youtube.com/"));


        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        QuakeArrayAdapter adapter = new QuakeArrayAdapter(
                this,earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                earthQuakeData currentPosition = adapter.getItem(i);
                Uri linkUrl = Uri.parse(currentPosition.getUrl());
                Intent in = new Intent(Intent.ACTION_VIEW,linkUrl);
                startActivity(in);

            }
        });
    }
}