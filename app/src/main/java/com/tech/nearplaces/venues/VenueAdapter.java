package com.tech.nearplaces.venues;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tech.nearplaces.R;
import com.tech.nearplaces.data.model.Venue;

import java.util.ArrayList;
import java.util.List;

public class VenueAdapter extends RecyclerView.Adapter<VenueViewHolder> {

    private List<Venue> mVenueList = new ArrayList<>();
    private Context mContext;

    public VenueAdapter(List<Venue> mVenueList, Context context) {
        this.mVenueList = mVenueList;
        mContext = context;
    }

    @NonNull
    @Override
    public VenueViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return
                new VenueViewHolder(LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.venue_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VenueViewHolder venueViewHolder, int i) {
        venueViewHolder.onBind(mVenueList.get(i), mContext);
    }

    @Override
    public int getItemCount() {
        return mVenueList.size();
    }
}
