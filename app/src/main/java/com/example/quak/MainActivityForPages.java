package com.example.quak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivityForPages extends AppCompatActivity {
    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_for_pages);

        // Create a fake list of earthquake locations.
        final String[] s1 = new String[1];
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        Log.d("eror","before");

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,"https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-01-31&minmag=6&limit=10",null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    String s = response.toString();
                    Log.d("eror",s);
                    System.out.println("hello");
                    s1[0] =s;
                }catch (Exception e){
                    Log.d("eror",e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("eror",error.getMessage());
            }
        });
        Log.d("eror","after");
        requestQueue.add(jsonObjectRequest);

        ArrayList<earthQuakeData> earthquakes = QueryUtils.extractEarthquakes(s1[0]);



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