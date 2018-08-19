package com.example.dguastaf.playground.Adapters;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dguastaf.playground.Models.FeedItem;
import com.example.dguastaf.playground.R;
import com.example.dguastaf.playground.ViewModels.FeedViewModel;
import com.example.dguastaf.playground.Views.FeedItemViewHolder;
import com.example.dguastaf.playground.databinding.FeedItemBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class FeedAdapter extends RecyclerView.Adapter<FeedItemViewHolder> {

    private FeedViewModel feedViewModel;

    public FeedAdapter(@NonNull LifecycleOwner lifecycleOwner, @NonNull FeedViewModel feedViewModel) {
        this.feedViewModel = feedViewModel;
        feedViewModel.getFeed().observe(lifecycleOwner, new Observer<List<FeedItem>>() {
            @Override
            public void onChanged(@Nullable List<FeedItem> feedItems) {
                notifyDataSetChanged();
            }
        });
    }

    @NonNull
    @Override
    public FeedItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        FeedItemBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.feed_item, viewGroup, false);


        return new FeedItemViewHolder(binding, feedViewModel);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedItemViewHolder feedItemViewHolder, int idx) {
        if (feedViewModel.getFeed().getValue() == null) {
            throw new IllegalStateException("Feed View Model doesn't have any feed data.");
        }
        feedItemViewHolder.bind(feedViewModel.getFeed().getValue().get(idx), idx);
    }

    @Override
    public int getItemCount() {
        if (feedViewModel.getFeed().getValue() == null) {
            return 0;
        }
        return feedViewModel.getFeed().getValue().size();
    }
}
