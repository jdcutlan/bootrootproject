package com.example.joe.bootrootproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu); /*Connects this Java file to its appropriate XML layout file*/
}

    public void onButtonClick(View v) /* These buttons allow navigation within the application */
    {
        if(v.getId() == R.id.LTF)
        {
            Intent i = new Intent(MainMenu.this, LeagueTable.class);
            startActivity(i);
        }

        if(v.getId() == R.id.PS)
        {
            Intent i = new Intent(MainMenu.this, PlayerStats.class);
            startActivity(i);
        }

        if(v.getId() == R.id.PAV)
        {
            Intent i = new Intent(MainMenu.this, PhotosAndVideos.class);
            startActivity(i);
        }

        if(v.getId() == R.id.LW)
        {
            Intent i = new Intent(MainMenu.this, Grounds.class);
            startActivity(i);
        }

        if(v.getId() == R.id.PI)
        {
            Intent i = new Intent(MainMenu.this, ParkingInformation.class);
            startActivity(i);
        }

        if(v.getId() == R.id.SACI)
        {
            Intent i = new Intent(MainMenu.this, StaffAndContactInfo.class);
            startActivity(i);
        }
    }
}
