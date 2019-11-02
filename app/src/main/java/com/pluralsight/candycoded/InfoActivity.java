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
    // DONE BY TAKOUMBO MBE Bernard Yvan
    // Thanks to PLURALSIGHT AND GOOGLE
    // ***


    public void createMapIntent(View view)
    {
        // Let's create the location data

        Uri uriLocationAdress = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");

        // Creating the implicit intent

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uriLocationAdress);

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
    // DONE BY TAKOUMBO MBE Bernard Yvan
    // Thanks to PLURALSIGHT AND GOOGLE
    // ***

    public void createPhoneIntent(View view)
    {
        // Creating our implicit intent to handle phone dial

        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);

        // Creating the data (phone number) to be passed to the intent for automatic load

        Uri phoneNumberUri = Uri.parse("tel:0123456789");

        // Passing the data to the phoneIntent

        phoneIntent.setData(phoneNumberUri);

        // Start the activity

        // We're not going to test the presence of a specified app because every telephone application. So we start Directly

        startActivity(phoneIntent);
    }
}
