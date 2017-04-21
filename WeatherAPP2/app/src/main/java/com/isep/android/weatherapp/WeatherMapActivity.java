package com.isep.android.weatherapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class WeatherMapActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private Marker marker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_map); //Assign the .xml

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
        mMap.setOnMapClickListener(this);
    }

    @Override
    public void onMapClick(LatLng coordinate) {
        WeatherConditions conditions = new WeatherConditions();
        conditions.setPoint(coordinate.toString());

        //If there is a marker already in the map, delete it
        removeMarker();

        marker = mMap.addMarker(new MarkerOptions().position(coordinate).title("The coordinates of the point are:"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coordinate));
        marker.setSnippet(coordinate.toString());
        marker.showInfoWindow();
    }

    public void removeMarker() {
        if (marker != null) {
            marker.remove();
            marker = null;
        }
    }
}
