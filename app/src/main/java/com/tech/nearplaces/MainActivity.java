package com.tech.nearplaces;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.tech.nearplaces.data.model.Item;
import com.tech.nearplaces.data.model.Venue;
import com.tech.nearplaces.data.remote.VenueRemoteDataSource;
import com.tech.nearplaces.venues.VenueAdapter;
import com.tech.nearplaces.venues.VenueItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    VenueItemViewModel mVenueItemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVenueItemViewModel = ViewModelProviders.of(this).get(VenueItemViewModel.class);
        ProgressBar progressBar = findViewById(R.id.progress_bar);

        RecyclerView recyclerView = findViewById(R.id.venue_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        setProgressBarIndeterminateVisibility(true);
        mVenueItemViewModel.fetchVenuesFromRemote(recyclerView, getApplicationContext());
        progressBar.setVisibility(View.GONE);


    }
}
