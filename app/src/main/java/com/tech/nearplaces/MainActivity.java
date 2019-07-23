package com.tech.nearplaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tech.nearplaces.data.remote.VenueRemoteDataSource;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VenueRemoteDataSource.fetchVenues();
    }
}
