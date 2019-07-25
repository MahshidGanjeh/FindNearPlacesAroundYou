package com.tech.nearplaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.tech.nearplaces.data.model.Item;
import com.tech.nearplaces.data.model.Venue;
import com.tech.nearplaces.data.remote.VenueRemoteDataSource;
import com.tech.nearplaces.venues.VenueAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Item> itemsList = new ArrayList<>();
    List<Venue> venueslist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.venue_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        VenueRemoteDataSource dataSource = new VenueRemoteDataSource();
        dataSource.fetchVenues().subscribe(result ->
        {
            itemsList = result;
            for (int i = 0; i < itemsList.size() - 1; i++) {
                venueslist.add(itemsList.get(i).getVenue());
            }
            VenueAdapter adapter = new VenueAdapter(venueslist, getApplicationContext());
            recyclerView.setAdapter(adapter);
        });
        
    }
}
