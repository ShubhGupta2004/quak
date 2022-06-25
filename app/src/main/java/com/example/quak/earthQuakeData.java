package com.example.quak;

public class earthQuakeData {
    private final String name;
    private final double mag;
    private final String date;

    earthQuakeData(String name,double mag,String date){
        this.date=date;
        this.mag=mag;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public double getMag() {
        return mag;
    }

    public String getDate() {
        return date;
    }
}
