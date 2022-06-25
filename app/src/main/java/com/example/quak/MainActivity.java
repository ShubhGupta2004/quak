package com.example.quak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a fake list of earthquake locations.
        ArrayList<earthQuakeData> earthquakes = new ArrayList<>();

        earthquakes.add(new earthQuakeData("san fransisco",7.1,"27"));
        earthquakes.add(new earthQuakeData("san fransisco",7.2,"27"));
        earthquakes.add(new earthQuakeData("san fransisco",7.3,"27"));
        earthquakes.add(new earthQuakeData("san fransisco",7.4,"27"));
        earthquakes.add(new earthQuakeData("san fransisco",7.5,"27"));
        earthquakes.add(new earthQuakeData("san fransisco",7.6,"27"));
        earthquakes.add(new earthQuakeData("san fransisco",7.7,"27"));
        earthquakes.add(new earthQuakeData("san fransisco",7.8,"27"));
        earthquakes.add(new earthQuakeData("san fransisco",7.9,"27"));
        earthquakes.add(new earthQuakeData("san fransisco",7.0,"27"));


        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}