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
        ArrayList<earthQuakeData> earthquakes = QueryUtils.extractEarthquakes();

        earthquakes.add(new earthQuakeData("san fransisco","7.1","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.2","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.3","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.4","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.5","27"));
        earthquakes.add(new earthQuakeData("san frandsisco","7.6","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.7","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.8","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.9","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.0","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.01","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.05","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.40","27"));
        earthquakes.add(new earthQuakeData("san fransisco","74.04","27"));
        //
        earthquakes.add(new earthQuakeData("san fransisco","7.340","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.30","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.30","27"));
        earthquakes.add(new earthQuakeData("san dransisco","7.30","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.320","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.3220","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.310","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.20","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.30","27"));
        earthquakes.add(new earthQuakeData("san fransisco","7.50","27"));


        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        QuakeArrayAdapter adapter = new QuakeArrayAdapter(
                this,earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}