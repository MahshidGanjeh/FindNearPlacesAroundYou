package com.tech.nearplaces;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.tech.nearplaces.data.model.Item;
import com.tech.nearplaces.data.model.Venue;
import com.tech.nearplaces.data.remote.VenueRemoteDataSource;
import com.tech.nearplaces.databinding.ActivityMainBinding;
import com.tech.nearplaces.venues.VenueAdapter;
import com.tech.nearplaces.venues.VenueDataViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        VenueDataViewModel dataViewModel = new VenueDataViewModel();
        binding.setViewmodel(dataViewModel);

        RecyclerView recyclerView = findViewById(R.id.venue_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


    }
}
