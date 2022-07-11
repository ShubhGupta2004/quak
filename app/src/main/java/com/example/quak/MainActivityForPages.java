package com.example.quak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivityForPages extends AppCompatActivity {
    //public static final String LOG_TAG = MainActivity.class.getName();
    public static final String url1 = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-01-31&minmag=6&limit=10";
    public static final String LOG_TAG = "shiro";
    public ArrayList<earthQuakeData> arr = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_for_pages);

        // Create a fake list of earthquake locations.


        TsunamiAsyncTask tsunamiAsyncTask = new TsunamiAsyncTask();
        tsunamiAsyncTask.execute();

        Log.d(LOG_TAG,arr.toString());

        //arr.add(new earthQuakeData("san fransisco","Alaska","7.1","WED 27 May 2022","03:00 PM","https://www.youtube.com/"));

    }

    private class TsunamiAsyncTask extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            // Create URL object
            URL url = createUrl(url1);

            // Perform HTTP request to the URL and receive a JSON response back
            String jsonResponse = "";
            try {
                jsonResponse = makeHttpRequest(url);
            } catch (IOException e) {
                // TODO Handle the IOException
            }

            // Extract relevant fields from the JSON response and create an {@link Event} object

            Log.d(LOG_TAG," l "+jsonResponse);
            // Return the {@link Event} object as the result fo the {@link TsunamiAsyncTask}
            return jsonResponse;
        }
        @Override
        protected void onPostExecute(String earthquake) {
            if (earthquake == null) {
                return;
            }

            arr=QueryUtils.extractEarthquakes(earthquake);


            arr.add(new earthQuakeData("san fransisco","Alaska","7.1","WED 27 May 2022","03:00 PM","https://www.youtube.com/"));

            // Find a reference to the {@link ListView} in the layout
            ListView earthquakeListView = findViewById(R.id.list);

            // Create a new {@link ArrayAdapter} of earthquakes
            QuakeArrayAdapter adapter = new QuakeArrayAdapter(MainActivityForPages.this,arr);

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

        private URL createUrl(String stringUrl) {
            URL url = null;
            try {
                url = new URL(stringUrl);
            } catch (MalformedURLException exception) {
                Log.e(LOG_TAG, "Error with creating URL", exception);
                return null;
            }
            return url;
        }



        /**
         * Make an HTTP request to the given URL and return a String as the response.
         */
        private String makeHttpRequest(URL url) throws IOException {
            String jsonResponse = "";
            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(10000 /* milliseconds */);
                urlConnection.setConnectTimeout(15000 /* milliseconds */);
                urlConnection.connect();
                if(urlConnection.getResponseCode()==200) {
                    inputStream = urlConnection.getInputStream();
                    jsonResponse = readFromStream(inputStream);
                }else{
                    Log.d("eror","The code is :"+urlConnection.getResponseCode() );
                }
            } catch (IOException e) {
                // TODO: Handle the exception
                assert urlConnection != null;
                if(urlConnection.getResponseCode()!=200) {
                    Log.e("eror", e.getMessage());
                }
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (inputStream != null) {
                    // function must handle java.io.IOException here
                    inputStream.close();
                }
            }
            return jsonResponse;
        }

        /**
         * Convert the {@link InputStream} into a String which contains the
         * whole JSON response from the server.
         */
        private String readFromStream(InputStream inputStream) throws IOException {
            StringBuilder output = new StringBuilder();
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    output.append(line);
                    line = reader.readLine();
                }

            }
            return output.toString();
        }


    }

}