package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);

        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***


    public void createMapIntent(View view)
    {
        // Let's create the location data

        Uri uriAdress = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");

        // Creating the implicit intent

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uriAdress);

        // To specify the app that's going to handle the intent, we use the setPackage method and passe in the app package name
        // In our case google maps

        mapIntent.setPackage("com.google.android.apps.maps");

        // Checking if the map app is installed before launching

        if(mapIntent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(mapIntent);
        }
        else
            Toast.makeText(this, "No application to open the map, please install Google Maps!!", Toast.LENGTH_LONG).show();
    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***
}
