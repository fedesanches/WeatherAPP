package com.isep.android.weatherapp;

import android.content.ContentValues;

public class WeatherConditions {
    private String point;
    private String temperature;
    private String wind;
    private String humidity;

    public WeatherConditions() {}

    public WeatherConditions(String point, String temperature, String wind, String humidity) {
        this.point = point;
        this.temperature = temperature;
        this.wind = wind;
        this.humidity = humidity;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    /*
    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(WeatherConditionsContract.WeatherEntry.COLUMN_NAME_LatLng, String.valueOf(point));
        values.put(WeatherConditionsContract.WeatherEntry.COLUMN_NAME_LatLng, String.valueOf(temperature));
        values.put(WeatherConditionsContract.WeatherEntry.COLUMN_NAME_LatLng, String.valueOf(wind));
        values.put(WeatherConditionsContract.WeatherEntry.COLUMN_NAME_LatLng, String.valueOf(humidity));
        return values;
    }
    */
}
