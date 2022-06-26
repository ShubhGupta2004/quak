package com.example.quak;

public class earthQuakeData {
    private final String name;
    private final String country;

    private final String mag;
    private final String date;
    private final String Url;
    private final String time;

    public earthQuakeData(String name, String country, String mag, String date, String time,String Url) {
        this.name = name;
        this.country = country;
        this.mag = mag;
        this.date = date;
        this.time = time;
        this.Url=Url;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getUrl() {
        return Url;
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
