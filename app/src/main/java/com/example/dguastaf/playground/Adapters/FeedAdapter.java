package com.example.dguastaf.playground.Adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dguastaf.playground.Models.FeedItem;
import com.example.dguastaf.playground.R;
import com.example.dguastaf.playground.Views.FeedItemViewHolder;
import com.example.dguastaf.playground.databinding.FeedItemBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class FeedAdapter extends RecyclerView.Adapter<FeedItemViewHolder> {

    private List<FeedItem> feedItems;

    public FeedAdapter() {
        feedItems = new ArrayList<>();
    }

    @NonNull
    @Override
    public FeedItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        FeedItemBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.feed_item, viewGroup, false);


        return new FeedItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedItemViewHolder feedItemViewHolder, int i) {
        feedItemViewHolder.bind(feedItems.get(i));
    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    public void setFeedItems(List<FeedItem> feedItems) {
        this.feedItems = feedItems;
        notifyDataSetChanged();
    }
}
