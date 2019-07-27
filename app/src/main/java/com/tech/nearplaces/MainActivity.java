package com.tech.nearplaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tech.nearplaces.data.model.Item;
import com.tech.nearplaces.data.model.Venue;
import com.tech.nearplaces.data.remote.VenueRemoteDataSource;
import com.tech.nearplaces.venues.VenueAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Item> resultItemsList = new ArrayList<>();
    List<Venue> venueslist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        VenueDataViewModel dataViewModel = new VenueDataViewModel();
//        binding.setViewmodel(dataViewModel);

        RecyclerView recyclerView = findViewById(R.id.venue_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        VenueRemoteDataSource dataSource = new VenueRemoteDataSource();
        dataSource.fetchVenues().subscribe(result ->
        {
            resultItemsList = result;
            for (int i = 0; i < resultItemsList.size() - 1; i++) {
                venueslist.add(resultItemsList.get(i).getVenue());
            }
            VenueAdapter adapter = new VenueAdapter(venueslist, getApplicationContext());
            recyclerView.setAdapter(adapter);
        });





    }
}
