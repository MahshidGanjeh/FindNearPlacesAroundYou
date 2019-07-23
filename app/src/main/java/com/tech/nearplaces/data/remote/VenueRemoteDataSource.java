package com.tech.nearplaces.data.remote;

import android.util.Log;

import com.tech.nearplaces.data.VenueRepository;
import com.tech.nearplaces.data.model.Example;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class VenueRemoteDataSource implements VenueRepository {

    public VenueRemoteDataSource() {
    }

    public static void fetchVenues() {

        String CLIENT_ID = "3TVQHARU45IF4YSJO4U4OUH2IEBWD5AJUZFWW1XHXYNA4XNC";
        String CLIENT_SECRET = "BSKNTD2PRL5T2QDPSFJWZMIUAKC3DQE5MHEAO3BG1ZDJUJE5";

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.foursquare.com/v2/venues/")
                .build();

        FoursquareApiService foursquareApiService =
                retrofit.create(FoursquareApiService.class);

        Observable<Example> example = (Observable<Example>) foursquareApiService.getVenues("44.3,37.2",
                CLIENT_ID,
                CLIENT_SECRET,
                "20190502");

        example.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(response -> response.getResponse().getGroups().get(0).getItems().get(0).getVenue().getName())
                .subscribe(ex -> Log.d("output", ": " + ex));
    }

}
