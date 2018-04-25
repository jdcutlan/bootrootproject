package com.example.joe.bootrootproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

public class PhotosAndVideos extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos_and_videos); /*Connects this Java file to its appropriate XML layout file*/

        String url ="www.cems.uwe.ac.uk/~j2-cutlan/modules_folder/ctp/bootroot/Gallery.php"; /* Grabs the designated webpage from the server */
        WebView view=(WebView) this.findViewById(R.id.webView); /*Makes use of the webview feature*/
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);

        Button btnCamera = (Button)findViewById(R.id.btnCamera); /* This is the camera button */


        btnCamera.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE); /*This starts the camera function once the button is clicked */
                startActivityForResult(intent,0 );
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(bitmap); /* This makes use of the image view feature */
    }

    public void onButtonClick(View v) /* These buttons allow navigation within the application */
    {

        if(v.getId() == R.id.mainmenupav)
        {
            Intent i = new Intent(PhotosAndVideos.this, MainMenu.class);
            startActivity(i);
        }

    }
}