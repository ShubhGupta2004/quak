package com.example.quak;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class QuakeArrayAdapter extends ArrayAdapter<earthQuakeData> {

    QuakeArrayAdapter(Context context, List<earthQuakeData> arrayAdapter){
        super(context,0, arrayAdapter);

    }

}
