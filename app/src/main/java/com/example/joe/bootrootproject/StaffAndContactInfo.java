package com.example.joe.bootrootproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;

public class StaffAndContactInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_and_contact_info); /*Connects this Java file to its appropriate XML layout file*/

        String url = "www.cems.uwe.ac.uk/~j2-cutlan/modules_folder/ctp/bootroot/StaffAndContactTeams.php"; /* Grabs the designated webpage from the server */
        WebView view = (WebView) this.findViewById(R.id.webView); /*Makes use of the webview feature*/
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);
    }

    public void onButtonClick(View v) /* These buttons allow navigation within the application */
    {
        if (v.getId() == R.id.mainmenu)
        {
            Intent i = new Intent(StaffAndContactInfo.this, MainMenu.class);
            startActivity(i);
        }

        if (v.getId() == R.id.rumneystaffbutton)
        {
            Intent i = new Intent(StaffAndContactInfo.this, RumneyStaff.class);
            startActivity(i);
        }
    }
}
