package com.tech.nearplaces.data.remote;

import android.util.Log;

import com.tech.nearplaces.data.VenueRepository;
import com.tech.nearplaces.data.model.Example;
import com.tech.nearplaces.data.model.Item;
import com.tech.nearplaces.data.model.Venue;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class VenueRemoteDataSource implements VenueRepository {


    public static List<Item> mItemList = new ArrayList<>();
    public Observer<List<Item>> observer;

    public VenueRemoteDataSource() {
        //mItemList = items;

    }

    public Observable<List<Item>> fetchVenues() {

        String CLIENT_ID = "3TVQHARU45IF4YSJO4U4OUH2IEBWD5AJUZFWW1XHXYNA4XNC";
        String CLIENT_SECRET = "BSKNTD2PRL5T2QDPSFJWZMIUAKC3DQE5MHEAO3BG1ZDJUJE5";

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.foursquare.com/v2/venues/")
                .build();

        FoursquareApiService foursquareApiService =
                retrofit.create(FoursquareApiService.class);

        Observable<Example> example = foursquareApiService.getVenues("40.7,-74",
                CLIENT_ID,
                CLIENT_SECRET,
                "20190502");


        return
                example.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(response ->
                        {
                            if (response != null) {
                                return response.getResponse().getGroups().get(0).getItems();
                            } else {
                                return new ArrayList<>();
                            }
                        });
        //.subscribe(getObserver());

        //setObserver();
    }



   /* public Observer getObserver(){
        observer = new Observer<List<Item>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Item> items) {
                mItemList = items;
                Log.d("mahshid", "fetchVenues: " + mItemList.size());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        return observer;
    }*/

}
