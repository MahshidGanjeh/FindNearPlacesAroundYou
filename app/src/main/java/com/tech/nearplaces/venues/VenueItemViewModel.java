package com.tech.nearplaces.venues;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.tech.nearplaces.data.model.Item;
import com.tech.nearplaces.data.model.Venue;
import com.tech.nearplaces.data.remote.VenueRemoteDataSource;

import java.util.ArrayList;
import java.util.List;

public class VenueItemViewModel extends ViewModel {

    List<Item> resultItemsList = new ArrayList<>();
    final List<Venue> venueslist = new ArrayList<>();

    MutableLiveData<String> _iconPath = new MutableLiveData<>();
    LiveData<String> iconPath = _iconPath;

    MutableLiveData<String> _venueName = new MutableLiveData<>();
    LiveData<String> venueName = _venueName;

    //MutableLiveData<String> _
    public void fetchVenuesFromRemote(RecyclerView rv, Context context) {


        VenueRemoteDataSource dataSource = new VenueRemoteDataSource();
        dataSource.fetchVenues().subscribe(result ->
        {
            resultItemsList = result;
            for (int i = 0; i < resultItemsList.size() - 1; i++) {
                venueslist.add(resultItemsList.get(i).getVenue());
            }
            VenueAdapter adapter = new VenueAdapter(venueslist,context);
            rv.setAdapter(adapter);
        });

    }
}
