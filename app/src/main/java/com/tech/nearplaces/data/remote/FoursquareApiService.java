package com.tech.nearplaces.data.remote;

import com.tech.nearplaces.data.model.Example;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoursquareApiService {

    @GET("explore?")
    Observable<Example> getVenues(
            @Query("ll") String latlng,
            @Query("client_id") String id,
            @Query("client_secret") String secret,
            @Query("v") String data
    );

}
