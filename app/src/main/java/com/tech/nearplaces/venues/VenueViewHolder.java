package com.tech.nearplaces.venues;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tech.nearplaces.BR;
import com.tech.nearplaces.data.model.Venue;
import com.tech.nearplaces.databinding.VenueItemBinding;

public class VenueViewHolder extends RecyclerView.ViewHolder {

    TextView mNameTextView;
    TextView mAddressTextView;
    TextView mDistanceTextView;
    ImageView mIconImageView;

    private final ViewDataBinding mBinding;
    private Venue mVenue;

    public VenueViewHolder(VenueItemBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void onBind(VenueItemViewModel viewModel, Venue v) {
        //mBinding.viewmodel = viewModel;
        mBinding.setVariable(BR.viewmodel, viewModel);
        mBinding.setVariable(BR.venue, v);
        //obj.fetchImages();
        // binding.executePendingBindings();
    }


   /* public VenueViewHolder(@NonNull View itemView) {
        super(itemView);
        mNameTextView = itemView.findViewById(R.id.venue_name_tv);
        mAddressTextView = itemView.findViewById(R.id.venue_address_tv);
        mDistanceTextView = itemView.findViewById(R.id.venue_distance_tv);
        mIconImageView = itemView.findViewById(R.id.venue_icon_imgv);
    }*/


   /* public void onBind(Venue venue, Context context) {
        mNameTextView.setText(venue.getName());
        mAddressTextView.setText(venue.getLocation().getAddress());
        mDistanceTextView.setText(venue.getLocation().getDistance().toString() + " km");
        String iconPath = venue.getCategories().get(0).getIcon().getPrefix() + "bg_64" +
                venue.getCategories().get(0).getIcon().getSuffix();
        Log.d("TTT", iconPath);
        Glide.with(context)
                .load(iconPath)
                .into(mIconImageView);

    }*/
}
