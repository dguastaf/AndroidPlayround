package com.example.dguastaf.playground.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dguastaf.playground.Models.FeedItem;
import com.example.dguastaf.playground.R;
import com.example.dguastaf.playground.Views.FeedItemViewHolder;

import java.util.ArrayList;
import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedItemViewHolder> {

    List<FeedItem> feedItems;

    public FeedAdapter() {
        feedItems = new ArrayList<>();
    }

    @NonNull
    @Override
    public FeedItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView t = new TextView(viewGroup.getContext());
        t.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        return new FeedItemViewHolder(t);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedItemViewHolder feedItemViewHolder, int i) {
        feedItemViewHolder.getTitleLabel().setText(feedItems.get(i).getTitle());
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
