package com.example.quak;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

public class QuakeArrayAdapter extends ArrayAdapter<earthQuakeData> {

    QuakeArrayAdapter(Context context, List<earthQuakeData> arrayAdapter){
        super(context,0, arrayAdapter);

    }
    public int getColor(double magnitude){

        int mag1 = (int) Math.floor(magnitude);
        int resourceId;

        switch (mag1){
            case 1:
                resourceId=R.color.magni1;
                break;
            case 2:
                resourceId=R.color.magni2;
                break;
            case 3:
                resourceId=R.color.magni3;
                break;
            case 4:
                resourceId=R.color.magni4;
                break;
            case 5:
                resourceId=R.color.magni5;
                break;
            case 6:
                resourceId=R.color.magni6;
                break;
            default:
                resourceId=R.color.magni7;
                break;

        }

        Log.d("quack", mag1+" "+resourceId);


        return ContextCompat.getColor(getContext(),resourceId);

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
        GradientDrawable gradientDrawable = (GradientDrawable) magnitudeView.getBackground();

        double man = Double.parseDouble( currentEarthQuake.getMag());

        int returnColor = getColor(man);

        gradientDrawable.setColor(returnColor);
        //magnitudeView.setBackgroundColor(returnColor);
        magnitudeView.setText(currentEarthQuake.getMag());

        TextView locationView = listView.findViewById(R.id.location);
        locationView.setText(currentEarthQuake.getName());

        TextView dateView = listView.findViewById(R.id.dateOfIncident);
        dateView.setText(currentEarthQuake.getDate());

        TextView TimeView = listView.findViewById(R.id.timeOfIncident);
        TimeView.setText(currentEarthQuake.getTime());

        TextView countryView = listView.findViewById(R.id.country);
        countryView.setText(currentEarthQuake.getCountry());




        return listView;
    }
}
