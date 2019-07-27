package com.tech.nearplaces.venues;

import android.arch.lifecycle.ViewModel;
import android.databinding.BaseObservable;

import com.tech.nearplaces.data.model.Item;
import com.tech.nearplaces.data.model.Venue;
import com.tech.nearplaces.data.remote.VenueRemoteDataSource;

import java.util.ArrayList;
import java.util.List;

public class VenueDataViewModel extends BaseObservable {

    List<Item> resultItemsList = new ArrayList<>();
    List<Venue> venueslist = new ArrayList<>();

    private VenueAdapter mVenueAdapter;
    private List<Venue> mVenueList;

    public VenueDataViewModel() {
        this.mVenueAdapter = new VenueAdapter();
        this.mVenueList = new ArrayList<>();
    }

    public void populateData() {
        VenueRemoteDataSource dataSource = new VenueRemoteDataSource();
        dataSource.fetchVenues().subscribe(result ->
        {
            resultItemsList = result;
            for (int i = 0; i < resultItemsList.size() - 1; i++) {
                mVenueList.add(resultItemsList.get(i).getVenue());
            }
         //   VenueAdapter adapter = new VenueAdapter(venueslist, getApplicationContext());
          //  recyclerView.setAdapter(adapter);
        });

        // notifyPropertyChanged(BR.data);

    }
}
