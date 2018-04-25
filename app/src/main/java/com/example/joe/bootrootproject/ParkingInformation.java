package com.example.joe.bootrootproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ParkingInformation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_info); /*Connects this Java file to its appropriate XML layout file*/
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map); /*Makes use of the map fragment*/
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng cardiffuniversitysportfields = new LatLng(51.516104, -3.136114);
        mMap.addMarker(new MarkerOptions().position(cardiffuniversitysportfields).title("Cardiff University Sport Fields"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cardiffuniversitysportfields));

        LatLng newroadfields = new LatLng(51.501244, -3.130000); /* This sets the latitude and longitude for the pin */
        mMap.addMarker(new MarkerOptions().position(newroadfields).title("New Road Fields")); /* Sets the name of the pin */
        mMap.moveCamera(CameraUpdateFactory.newLatLng(newroadfields));

        LatLng pontcannafields = new LatLng(51.493420, -3.199589);
        mMap.addMarker(new MarkerOptions().position(pontcannafields).title("Pontcanna Fields"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pontcannafields));

        LatLng trelaipark = new LatLng(51.478612, -3.230816);
        mMap.addMarker(new MarkerOptions().position(trelaipark).title("Trelai Park"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(trelaipark));

        LatLng haileypark = new LatLng(51.507349, -3.234596);
        mMap.addMarker(new MarkerOptions().position(haileypark).title("Hailey Park"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(haileypark));

        LatLng llandafffields = new LatLng(51.491629, -3.207225);
        mMap.addMarker(new MarkerOptions().position(llandafffields).title("Llandaff Fields"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(llandafffields));

        LatLng cefnonnpark = new LatLng(51.546024, -3.186144);
        mMap.addMarker(new MarkerOptions().position(cefnonnpark).title("Cefn Onn Park"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cefnonnpark));

        LatLng caedelynpark = new LatLng(51.519966, -3.217133);
        mMap.addMarker(new MarkerOptions().position(caedelynpark).title("Caedelyn Park"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(caedelynpark));

        LatLng fairwaterpark = new LatLng(51.493396, -3.238684);
        mMap.addMarker(new MarkerOptions().position(fairwaterpark).title("Fairwater Park"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(fairwaterpark));

        LatLng heathpark = new LatLng(51.514959, -3.186110);
        mMap.addMarker(new MarkerOptions().position(heathpark).title("Heath Park"));
        float zoomLevel = 12.0f; //This is the default zoom when Google Maps is launched
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(heathpark, zoomLevel)); /* This sets the default camera view over the 'heath park' pin */
    }

    public void onButtonClick(View v) /* These buttons allow navigation within the application */
    {
        if (v.getId() == R.id.mainmenu)
        {
            Intent i = new Intent(ParkingInformation.this, MainMenu.class);
            startActivity(i);
        }
    }
}