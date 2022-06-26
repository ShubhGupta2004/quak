package com.example.quak;

public class earthQuakeData {
    private final String name;
    private final String country;

    private final String mag;
    private final String date;

    private final String time;

    public earthQuakeData(String name, String country, String mag, String date, String time) {
        this.name = name;
        this.country = country;
        this.mag = mag;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getMag() {
        return mag;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
