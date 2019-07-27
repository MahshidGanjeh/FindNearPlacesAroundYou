package com.tech.nearplaces.venues;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class VenueItemViewModel extends ViewModel {

    MutableLiveData<String> _iconPath = new MutableLiveData<>();
    LiveData<String> iconPath = _iconPath;

    MutableLiveData<String> _venueName = new MutableLiveData<>();
    LiveData<String> venueName = _venueName;

    //MutableLiveData<String> _
}
