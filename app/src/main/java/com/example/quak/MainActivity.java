package com.example.quak;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public String[] s1 = new String[1];
    JSONObject obj1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Hello..", Toast.LENGTH_SHORT).show();
        RequestQueue requestQueue;
        requestQueue= Volley.newRequestQueue(this);


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-01-31&minmag=6&limit=10", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.d("bsj",response.toString());
                        obj1=response.getJSONObject("features");
//                    //JSONArray arr = new JSONArray("")
//                    //System.out.println(response);
//                    Log.d("eror","url");
//                    String s = response.toString();
//                    Log.d("eror"," l "+s);
//                    System.out.println("hello");
//                    //s1[0] =s;
//                    Log.d("bsj",s+" "+s1[0]);

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("bsj","kk" +e);
                    Toast.makeText(MainActivity.this, "Something went wrong 1", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("bsj","Something Went Wrong"+error.getMessage());
                Toast.makeText(MainActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });




        requestQueue.add(jsonObjectRequest);

        //Log.d("bsj",s1[0]);
        Log.d("bsj",obj1.toString());

    }

    public void play(View view){

        Intent in = new Intent(this,MainActivityForPages.class);
        startActivity(in);
    }
}