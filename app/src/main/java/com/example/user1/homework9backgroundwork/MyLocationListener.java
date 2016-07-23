package com.example.user1.homework9backgroundwork;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by user1 on 23.7.2016 г..
 */
public class MyLocationListener implements LocationListener {

    int count = 1;
    private static final String TAG = "";

    @Override
    public void onLocationChanged(Location loc) {


        String longitude = "Longitude: " + loc.getLongitude();
        Log.v(TAG, longitude);
        String latitude = "Latitude: " + loc.getLatitude();
        Log.v(TAG, latitude);

        String s = count++ + " " + longitude + latitude + "\n";
        MainActivity.txtGps.setText(String.valueOf(MainActivity.txtGps.getText()) + s + "\n");
        PreferenceManager.getDefaultSharedPreferences(MainActivity.context).edit()
                .putString("Location", String.valueOf(MainActivity.txtGps.getText())).commit();


    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }


}
