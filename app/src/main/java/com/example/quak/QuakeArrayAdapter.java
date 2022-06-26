package com.example.quak;

import  android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class QuakeArrayAdapter extends ArrayAdapter<earthQuakeData> {

    QuakeArrayAdapter(Context context, List<earthQuakeData> arrayAdapter){
        super(context,0, arrayAdapter);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if (listView==null){
            listView= LayoutInflater.from(getContext()).inflate(R.layout.list_for_adapter,parent,false);
        }

        earthQuakeData currentEarthQuake = getItem(position);

        TextView magnitudeView = listView.findViewById(R.id.magnitude);
        magnitudeView.setText(currentEarthQuake.getMag());

        TextView locationView = listView.findViewById(R.id.location);
        locationView.setText(currentEarthQuake.getName());

        TextView dateView = listView.findViewById(R.id.dateOfIncident);
        dateView.setText(currentEarthQuake.getDate());

        return listView;
    }
}
