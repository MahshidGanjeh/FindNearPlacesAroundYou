package com.tech.nearplaces.venues;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tech.nearplaces.R;
import com.tech.nearplaces.data.model.Venue;
import com.tech.nearplaces.databinding.VenueItemBinding;

import java.util.ArrayList;
import java.util.List;

public class VenueAdapter extends RecyclerView.Adapter<VenueViewHolder> {

    private List<Venue> mVenueList = new ArrayList<>();
    private Context mContext;

    public VenueAdapter() {
    }

    public VenueAdapter(List<Venue> mVenueList, Context context) {
        this.mVenueList = mVenueList;
        mContext = context;

    }

    @NonNull
    @Override
    public VenueViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        VenueItemBinding binding =
                VenueItemBinding.inflate(
                        LayoutInflater.from(viewGroup.getContext()),
                        viewGroup,
                        false
                );
        return
                new VenueViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VenueViewHolder venueViewHolder, int i) {
        VenueItemViewModel vm = new VenueItemViewModel();
        venueViewHolder.onBind(vm, mVenueList.get(i));
    }

    @Override
    public int getItemCount() {
        return mVenueList.size();
    }
}
