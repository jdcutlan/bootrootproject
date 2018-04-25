package com.example.joe.bootrootproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;

public class Rumney extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumney); /*Connects this Java file to its appropriate XML layout file*/

        String url = "www.cems.uwe.ac.uk/~j2-cutlan/modules_folder/ctp/bootroot/PlayerNames.php"; /* Grabs the designated webpage from the server */
        WebView view = (WebView) this.findViewById(R.id.webView); /*Makes use of the webview feature*/
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);
    }

    public void onButtonClick(View v) /* These buttons allow navigation within the application */
    {
        if (v.getId() == R.id.joecutlanbutton)
        {
            Intent i = new Intent(Rumney.this, JoeCutlanPage.class);
            startActivity(i);
        }

        if (v.getId() == R.id.backbutton1)
        {
            Intent i = new Intent(Rumney.this, PlayerStats.class);
            startActivity(i);
        }

        if (v.getId() == R.id.mainmenu)
        {
            Intent i = new Intent(Rumney.this, MainMenu.class);
            startActivity(i);
        }

    }

}
