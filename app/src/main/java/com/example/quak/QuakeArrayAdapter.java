package com.example.quak;

import android.app.Activity;
import android.widget.ArrayAdapter;

import java.util.List;

public class QuakeArrayAdapter extends ArrayAdapter<earthQuakeData> {

    QuakeArrayAdapter(Activity context,ArrayAdapter<earthQuakeData> arrayAdapter){
        super(context,0, (List<earthQuakeData>) arrayAdapter);
        
    }

}
